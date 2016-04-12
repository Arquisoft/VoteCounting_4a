package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.model.Voto;


public interface VoteService {
	
	public Votacion getVotacion(boolean status);
	public List<Voto> getPendingVotes();
	public List<Opcion> getAllOpciones(Votacion votacion);
}
