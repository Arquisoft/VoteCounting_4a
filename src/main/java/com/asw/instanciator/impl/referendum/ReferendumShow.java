package com.asw.instanciator.impl.referendum;

import java.util.List;

import com.asw.instanciator.VotesShow;
import com.asw.model.Voto;

public class ReferendumShow implements VotesShow {
	
	private List<Voto> resultados;

	@Override
	public void showResults() {	
		
	}

	@Override
	public void setResults(List<Voto> results) {
		resultados = results;
	}

}
