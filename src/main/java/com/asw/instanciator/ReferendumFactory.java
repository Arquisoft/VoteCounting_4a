package com.asw.instanciator;

import com.asw.instanciator.impl.referendum.ReferendumCalc;
import com.asw.instanciator.impl.referendum.ReferendumShow;

public class ReferendumFactory extends AbstractFactory {

	@Override
	VotesCalc crearCalc() {
		return new ReferendumCalc();
	}

	@Override
	VotesShow crearShow() {
		return new ReferendumShow();
	}
}
