package es.uniovi.asw.instanciator.impl.referendum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import es.uniovi.asw.conf.VotacionManager;
import es.uniovi.asw.instanciator.VotesShow;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Voto;

public class ReferendumShow extends VotesShow {

	public ReferendumShow() {
		super();
		setUpSectChart();
		setUpLineChart();
	}

	private void setUpLineChart() {
		lineChartModel = new LineChartModel();
	}

	private void setUpSectChart() {
		pieChartModel.setFill(false);
		pieChartModel.setShowDataLabels(true);
		pieChartModel.setTitle("Referendum - SECTORES");
		pieChartModel.setLegendPosition("ne");
	}

	@Override
	public void setResults(List<Voto> results) {
		setResultados(results);
	}

	@Override
	protected void updateChartLive() {
		for (Opcion o : VotacionManager.getVM().getOpciones()) {
			pieChartModel.getData().put(o.getNombre(), getVotosOpcion(o).size());
		}
	}

	@Override
	protected void updateChartLine() {
		lineChartModel = new LineChartModel();
		LineChartSeries series;
		for (Opcion o : VotacionManager.getVM().getOpciones()) {
			series = new LineChartSeries();
			series.setLabel(o.getNombre());

			Map<Date, List<Voto>> sorted = new TreeMap<Date, List<Voto>>(getVotosOpcion(o).stream()
					.collect(Collectors.groupingBy(Voto::getFechaVoto)));

			for (Map.Entry<Date, List<Voto>> entrada : sorted.entrySet()) {
				series.set(new SimpleDateFormat("HH:mm").format(entrada.getKey()), 
						entrada.getValue().size());
			}
			lineChartModel.addSeries(series);
		}

		lineChartModel.setTitle("Zoom para más detalles");
		lineChartModel.setZoom(true);
		lineChartModel.getAxis(AxisType.Y).setLabel("Cantidad de votos");
		DateAxis axis = new DateAxis("Horas");
		axis.setTickAngle(-50);
		axis.setMax("23:59");
		axis.setTickFormat("%H:%#M");

		lineChartModel.getAxes().put(AxisType.X, axis);
	}

	private List<Voto> getVotosOpcion(Opcion o) {
		return resultados.stream().filter(v -> v.getOpcion().getId() == o.getId()).collect(Collectors.toList());
	}
}
