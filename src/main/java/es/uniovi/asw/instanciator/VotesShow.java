package es.uniovi.asw.instanciator;

import java.util.List;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import es.uniovi.asw.model.Voto;

public abstract class VotesShow {
	
	protected VotesShow() {
		this.pieChartModel = new PieChartModel();
		this.lineChartModel = new LineChartModel();
	}

	// Datos
	protected List<Voto> resultados;

	// Graficas
	protected PieChartModel pieChartModel;
	protected LineChartModel lineChartModel;

	protected abstract void updateChartLive();
	protected abstract void updateChartLine();

	public PieChartModel getPieChartModel() {
		updateChartLive();
		return this.pieChartModel;
	}
	
	public LineChartModel getLineChartModel() {
		updateChartLine();
		return this.lineChartModel;
	}

	public abstract void setResults(List<Voto> results);
	
	public List<Voto> getResultados() {
		return resultados;
	}

	public void setResultados(List<Voto> resultados) {
		this.resultados = resultados;
	}
}
