package es.uniovi.asw.business.impl.votacion;

import es.uniovi.asw.conf.PersistenceFactory;
import es.uniovi.asw.model.Votacion;

public class ListVotacion {

	private boolean status;
	public ListVotacion(boolean status) {
		this.status = status;
	}

	public Votacion listAll() {
		return PersistenceFactory.getVotaciones().getActive(status);
	}
}
