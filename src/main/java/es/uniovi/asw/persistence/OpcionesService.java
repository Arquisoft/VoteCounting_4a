package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;

public interface OpcionesService {

	/**
	 * Metodo que devuelve una lista con todas las opciones de una votacion da
	 * ésta.
	 * 
	 * @param v
	 *            La votacion de la que queremos obtener las opciones
	 * @return Lista con las opciones de voto
	 */
	List<Opcion> getOpciones(Votacion v);

}
