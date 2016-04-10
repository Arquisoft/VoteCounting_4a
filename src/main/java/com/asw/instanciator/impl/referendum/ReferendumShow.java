package com.asw.instanciator.impl.referendum;

import java.util.List;

import com.asw.instanciator.VotesShow;
import com.asw.model.VotoDTO;

public class ReferendumShow implements VotesShow {
	
	private List<VotoDTO> resultados;

	@Override
	public void showResults() {	
		
	}

	@Override
	public void setResults(List<VotoDTO> results) {
		resultados = results;
	}

}
