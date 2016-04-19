package es.uniovi.asw.persistence;

import es.uniovi.asw.model.ColegioElectoral;

public interface ColegiosService {

	/**
	 * Metodo para buscar un colegio electoral en la base de datos dado un id.
	 * 
	 * @param id
	 *            del colegio electoral a buscar
	 * @return El colegio electoral, si es que existe
	 */
	ColegioElectoral findById(long id);

}
