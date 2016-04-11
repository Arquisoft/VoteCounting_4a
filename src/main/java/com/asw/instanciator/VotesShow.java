package com.asw.instanciator;

import java.util.List;

import org.primefaces.model.chart.PieChartModel;

import com.asw.model.Voto;

public interface VotesShow {
	
	void showResults();
	void setResults(List<Voto> results);
	
	PieChartModel getPieChartModel();
}
