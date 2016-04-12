package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.model.Voto;

public interface VoteService {
	
	public List<Votacion> listAllVotaciones();
	public List<Voto> getPendingVotes();
}
