package com.asw.instanciator.impl.referendum;

import java.util.List;

import org.primefaces.model.chart.PieChartModel;

import com.asw.instanciator.VotesShow;
import com.asw.model.Voto;

public class ReferendumShow implements VotesShow {
	
	private List<Voto> resultados;
	
	private PieChartModel livePieModel;
	 
    public PieChartModel getLivePieModel() {
        int random1 = (int)(Math.random() * 1000);
        int random2 = (int)(Math.random() * 1000);
 
        livePieModel.getData().put("Candidate 1", random1);
        livePieModel.getData().put("Candidate 2", random2);
         
        livePieModel.setTitle("Votes");
        livePieModel.setLegendPosition("ne");
         
        return livePieModel;
    }

	@Override
	public void showResults() {	
		
	}

	@Override
	public void setResults(List<Voto> results) {
		resultados = results;
	}

}
