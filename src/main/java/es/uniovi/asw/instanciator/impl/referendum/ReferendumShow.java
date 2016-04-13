package es.uniovi.asw.instanciator.impl.referendum;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartSeries;

import com.sun.faces.mgbean.ManagedBeanInfo.MapEntry;

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
		lineChartModel.setTitle("Zoom for Details");
		lineChartModel.setZoom(true);
		lineChartModel.getAxis(AxisType.Y).setLabel("Values");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
        axis.setMax("2014-02-01");
        axis.setTickFormat("%b %#d, %y");
         
        lineChartModel.getAxes().put(AxisType.X, axis);
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
		LineChartSeries series;
		for (Opcion o : VotacionManager.getVM().getOpciones()) {
			series = new LineChartSeries();
	        series.setLabel(o.getNombre());
	 
	        Map<Date,List<Voto>> grupos = 
	        		getVotosOpcion(o).stream().collect(
	        				Collectors.groupingBy(Voto::getFechaVoto));
	        
	        for (Map.Entry<Date, List<Voto>> entrada : grupos.entrySet()) {
	        	series.set(entrada.getKey(), entrada.getValue().size());
	        }
		}
	}

	private List<Voto> getVotosOpcion(Opcion o) {
		return resultados.stream()
				.filter(v -> v.getOpcion().getId() == o.getId())
				.collect(Collectors.toList());
	}
}
