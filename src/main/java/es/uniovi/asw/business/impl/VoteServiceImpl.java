package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.VoteService;
import es.uniovi.asw.business.impl.votacion.ListVotacion;
import es.uniovi.asw.business.impl.voto.ListVotes;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.model.Voto;

public class VoteServiceImpl implements VoteService {

	@Override
	public List<Votacion> listAllVotaciones() {
		return new ListVotacion().listAll();
	}

	@Override
	public List<Voto> getPendingVotes() {
		return new ListVotes().listPendingVotes();
	}
}
