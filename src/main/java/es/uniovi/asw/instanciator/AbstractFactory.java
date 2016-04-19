package es.uniovi.asw.instanciator;

public abstract class AbstractFactory {

	/**
	 * Metodo abstracto que se encarga de instanciar la forma de recuento de un
	 * determinado tipo de votacion.
	 * 
	 * @return
	 */
	public abstract VotesCalc crearCalc();

	/**
	 * Metodo abstracto que se encarga de instanciar la forma de representacion de un
	 * determinado tipo de votacion.
	 * @return
	 */
	public abstract VotesShow crearShow();
}
