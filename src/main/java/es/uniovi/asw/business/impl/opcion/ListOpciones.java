package es.uniovi.asw.business.impl.opcion;

import java.util.List;

import es.uniovi.asw.conf.PersistenceFactory;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;

public class ListOpciones {
	
	private Votacion votacion;
	
	public ListOpciones(Votacion votacion) {
		this.votacion = votacion;
	}

	public List<Opcion> listOptions() {
		return PersistenceFactory.getOpciones().getOpciones(votacion);
	}

}
