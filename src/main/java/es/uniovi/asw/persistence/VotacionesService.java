package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Votacion;

public interface VotacionesService {
	
	Votacion getActive(boolean opcion);

}
