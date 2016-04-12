package es.uniovi.asw.instanciator;

import java.util.List;

import org.primefaces.model.chart.PieChartModel;

import es.uniovi.asw.model.Voto;

public interface VotesShow {
	
	void showResults();
	void setResults(List<Voto> results);
	PieChartModel getLivePieModel();
}
