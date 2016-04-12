package es.uniovi.asw.conf;

import java.util.List;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;

public class VotacionManager {
	
	private static VotacionManager vm = null;
	
	private Votacion votacion;
	private List<Opcion> opciones;
	
	private VotacionManager() { }
	
	public static VotacionManager getVM() {
		if (vm == null) {
			vm = new VotacionManager();
		}
		return vm;
	}

	public void setVotacion(Votacion votacion) {
		this.votacion = votacion;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public Votacion getVotacion() {
		return votacion;
	}
}
