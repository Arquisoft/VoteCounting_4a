package com.asw.business.impl;

import java.util.List;

import com.asw.business.VoteService;
import com.asw.business.impl.votacion.ListVotacion;
import com.asw.model.Votacion;

public class VoteServiceImpl implements VoteService {

	@Override
	public List<Votacion> listAllVotaciones() {
		return new ListVotacion().listAll();
	}
}
