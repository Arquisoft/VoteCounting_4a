package es.uniovi.asw.instanciator;

import java.util.List;

import es.uniovi.asw.model.Voto;


public abstract class VotesCalc {
	
	/**
	 * Metodo el cual dada una lista de votos, realiza el recuento de resultados.
	 * @param votoscalculados
	 * @return
	 */
	public abstract List<Voto> calcularResultados(List<Voto> votoscalculados);

}
