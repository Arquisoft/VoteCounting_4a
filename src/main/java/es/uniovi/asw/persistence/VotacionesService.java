package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Votacion;

public interface VotacionesService {

	/**
	 * Metodo que comprueba, dada una votacion, si esta activa o no.
	 * 
	 * @param opcion
	 * @return
	 */
	Votacion getActive(boolean opcion);

}
