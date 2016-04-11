package com.asw.instanciator.impl.referendum;

import java.util.List;

import com.asw.instanciator.VotesCalc;
import com.asw.model.Voto;

public class ReferendumCalc extends VotesCalc{

	@Override
	public List<Voto> calcularResultados(List<Voto> votoscalculados) {
		//El referendum no implica ninguna operacion sobre los votos
		return votoscalculados;
	}
}
