package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;

public interface GetOpciones {
	
	List<Opcion> getOpciones(Votacion v);

}
