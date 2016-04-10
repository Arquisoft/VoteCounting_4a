package com.asw.instanciator;

import java.util.List;

import com.asw.model.VotoDTO;

public interface VotesShow {
	
	void showResults();
	void setResults(List<VotoDTO> results);
}
