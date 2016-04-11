package com.asw.instanciator;

import java.util.List;

import org.primefaces.model.chart.PieChartModel;

import com.asw.conf.ServicesFactory;
import com.asw.model.Opcion;
import com.asw.model.Voto;

public abstract class VotesShow {
	
	protected VotesShow() {
		opciones = ServicesFactory.getVotesService().getAllOpciones();
		this.pieChartModel = new PieChartModel();
	}

	// Datos
	protected List<Voto> resultados;
	protected List<Opcion> opciones;

	// Graficas
	protected PieChartModel pieChartModel;

	protected abstract void updateChartLive();

	public PieChartModel getPieChartModel() {
		updateChartLive();
		return this.pieChartModel;
	}

	public abstract void setResults(List<Voto> results);
	
	public List<Voto> getResultados() {
		return resultados;
	}

	public void setResultados(List<Voto> resultados) {
		this.resultados = resultados;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}
}
