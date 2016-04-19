package es.uniovi.asw.instanciator.impl.referendum;

import java.util.List;

import es.uniovi.asw.instanciator.VotesCalc;
import es.uniovi.asw.model.Voto;


public class ReferendumCalc extends VotesCalc{

	/* (non-Javadoc)
	 * @see es.uniovi.asw.instanciator.VotesCalc#calcularResultados(java.util.List)
	 */
	@Override
	public List<Voto> calcularResultados(List<Voto> votoscalculados) {
		//El referendum no implica ninguna operacion sobre los votos
		return votoscalculados;
	}
}
