package es.uniovi.asw.conf;

import java.util.List;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;

public class VotacionManager {
	
	private static VotacionManager vm = null;
	
	private Votacion votacion;
	private List<Opcion> opciones;
	
	private VotacionManager() { 
		votacion = ServicesFactory.getVotesService().getVotacion(true);
		assertVotacion();
		opciones = ServicesFactory.getVotesService().getAllOpciones(votacion);
	}
	
	public static VotacionManager getVM() {
		if (vm == null) {
			vm = new VotacionManager();
		}
		return vm;
	}

	private void assertVotacion() {
		if (votacion == null) {
			throw new RuntimeException("No hay votación activa.");
		}
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public Votacion getVotacion() {
		return votacion;
	}
}
