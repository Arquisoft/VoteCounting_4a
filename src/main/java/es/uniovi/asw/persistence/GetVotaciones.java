package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Votacion;

public interface GetVotaciones {
	
	Votacion getActive(boolean opcion);

}
