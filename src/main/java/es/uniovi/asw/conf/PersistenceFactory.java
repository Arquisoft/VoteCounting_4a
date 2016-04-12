package es.uniovi.asw.conf;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.persistence.GetColegiosElectorales;
import es.uniovi.asw.persistence.GetOpciones;
import es.uniovi.asw.persistence.GetVotaciones;
import es.uniovi.asw.persistence.GetVotos;
import es.uniovi.asw.persistence.impl.GetColegiosElectoralesImpl;
import es.uniovi.asw.persistence.impl.GetOpcionesImpl;
import es.uniovi.asw.persistence.impl.GetVotacionesImpl;
import es.uniovi.asw.persistence.impl.GetVotosImpl;
import es.uniovi.asw.persistence.repository.ColegiosElectoralesRepository;
import es.uniovi.asw.persistence.repository.OpcionesRepository;
import es.uniovi.asw.persistence.repository.VotacionesRepository;
import es.uniovi.asw.persistence.repository.VotosRepository;

public class PersistenceFactory {
	
	@Autowired
	private static VotosRepository votosRepo;
	
	@Autowired
	private static OpcionesRepository opcionesRepo;
	
	@Autowired
	private static VotacionesRepository votacionesRepo;
	
	@Autowired
	private static ColegiosElectoralesRepository colegiosRepo;
	
	public static GetVotos getVotos() {
		return new GetVotosImpl(votosRepo);
	}
	
	public static GetColegiosElectorales getColegiosElectorales() {
		return new GetColegiosElectoralesImpl(colegiosRepo);
	}
	
	public static GetOpciones getOpciones() {
		return new GetOpcionesImpl(opcionesRepo);
	}
	
	public static GetVotaciones getVotaciones() {
		return new GetVotacionesImpl(votacionesRepo);
	}
}
