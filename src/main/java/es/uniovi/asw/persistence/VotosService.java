package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Voto;

public interface VotosService {

	/**
	 * Metodo que devuelve todos los votos dado un colegio electoral.
	 * 
	 * @param ce
	 * @return
	 */
	List<Voto> getAllVotes(ColegioElectoral ce);

	/**
	 * Metodo para actualizar el estado de un voto dado a leido, con el fin de
	 * que no se cunete dos veces.
	 * 
	 * @param v
	 */
	void updateLeido(Voto v);

	/**
	 * Metodo que devuelve todos los votos dado un colegio electoral, que aun no
	 * han sido recontados.
	 * 
	 * @param leido
	 * @return
	 */
	List<Voto> votosLeidos(boolean leido);

}
