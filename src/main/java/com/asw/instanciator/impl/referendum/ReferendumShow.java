package com.asw.instanciator.impl.referendum;

import java.util.List;

import org.primefaces.model.chart.PieChartModel;

import com.asw.instanciator.prueba;
import com.asw.model.Opcion;
import com.asw.model.Voto;

public class ReferendumShow extends prueba {

	protected List<Voto> resultados;
	protected List<Opcion> opciones;

	@Override
	public void setResults(List<Voto> results) {
		setResultados(results);
	}
	
	protected void getChartLive() {
		showResults();
		pieChartModel.setTitle("Votes");
		pieChartModel.setLegendPosition("ne");
	}

	private int getVotosOpcion(Opcion o) {
		int cont = 0;
		for (Voto v : resultados) {
			if (v.getOpcion() == o.getId())
				cont++;
		}
		return cont;
	}

	@Override
	public void showResults() {
		for (Opcion o : opciones) {
			pieChartModel.getData().put(o.getNombre(), getVotosOpcion(o));
		}
	}

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

	public void setPieChartModel(PieChartModel pieChartModel) {
		this.pieChartModel = pieChartModel;
	}
}
