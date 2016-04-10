package com.asw.business;

import java.util.List;

import com.asw.model.Votacion;
import com.asw.model.Voto;

public interface VoteService {
	
	public List<Votacion> listAllVotaciones();
	public List<Voto> getPendingVotes();
}
