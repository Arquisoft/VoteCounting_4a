package com.asw.business.impl;

import java.util.List;

import com.asw.business.VoteService;
import com.asw.business.impl.opcion.ListOpciones;
import com.asw.business.impl.votacion.ListVotacion;
import com.asw.business.impl.voto.ListVotes;
import com.asw.model.Opcion;
import com.asw.model.Votacion;
import com.asw.model.Voto;

public class VoteServiceImpl implements VoteService {

	@Override
	public List<Votacion> listAllVotaciones() {
		return new ListVotacion().listAll();
	}

	@Override
	public List<Voto> getPendingVotes() {
		return new ListVotes().listPendingVotes();
	}

	@Override
	public List<Opcion> getAllOpciones() {
		return new ListOpciones().listOptions();
	}
}
