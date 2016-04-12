package es.uniovi.asw.business.impl.voto;

import java.util.List;

import es.uniovi.asw.conf.PersistenceFactory;
import es.uniovi.asw.model.Voto;

public class ListVotes {

	public List<Voto> listPendingVotes() {
		return PersistenceFactory.getVotos().votosLeidos(false);
	}
}
