package com.asw.instanciator;

import com.asw.instanciator.impl.referendum.ReferendumCalc;
import com.asw.instanciator.impl.referendum.ReferendumShow;

public class ReferendumFactory extends AbstractFactory {

	@Override
	public VotesCalc crearCalc() {
		return new ReferendumCalc();
	}

	@Override
	public prueba crearShow() {
		return new ReferendumShow();
	}
}
