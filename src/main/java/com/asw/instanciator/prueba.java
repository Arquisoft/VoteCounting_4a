package com.asw.instanciator;

import java.util.List;

import org.primefaces.model.chart.PieChartModel;

import com.asw.model.Voto;

public abstract class prueba {
	
	protected PieChartModel pieChartModel;
	
	protected abstract void showResults();
	protected abstract void getChartLive();
	public abstract void setResults(List<Voto> results);
	
	public PieChartModel getPieChartModel() {
		getChartLive();
		return this.pieChartModel;
	}
}
