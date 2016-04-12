package es.uniovi.asw.instanciator;

import es.uniovi.asw.instanciator.impl.referendum.ReferendumCalc;
import es.uniovi.asw.instanciator.impl.referendum.ReferendumShow;

public class ReferendumFactory extends AbstractFactory {

	@Override
	public VotesCalc crearCalc() {
		return new ReferendumCalc();
	}

	@Override
	public VotesShow crearShow() {
		return new ReferendumShow();
	}
}
