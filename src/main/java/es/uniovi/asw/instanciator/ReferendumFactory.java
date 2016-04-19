package es.uniovi.asw.instanciator;

import es.uniovi.asw.instanciator.impl.referendum.ReferendumCalc;
import es.uniovi.asw.instanciator.impl.referendum.ReferendumShow;

public class ReferendumFactory extends AbstractFactory {

	/* (non-Javadoc)
	 * @see es.uniovi.asw.instanciator.AbstractFactory#crearCalc()
	 */
	@Override
	public VotesCalc crearCalc() {
		return new ReferendumCalc();
	}

	/* (non-Javadoc)
	 * @see es.uniovi.asw.instanciator.AbstractFactory#crearShow()
	 */
	@Override
	public VotesShow crearShow() {
		return new ReferendumShow();
	}
}
