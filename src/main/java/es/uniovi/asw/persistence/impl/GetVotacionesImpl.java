package es.uniovi.asw.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.persistence.GetVotaciones;
import es.uniovi.asw.persistence.repository.VotacionesRepository;

public class GetVotacionesImpl implements GetVotaciones {

	private final VotacionesRepository repo;
	
	@Autowired
	public GetVotacionesImpl(VotacionesRepository repo)
	{
		this.repo = repo;
	}

	@Override
	public Votacion getActive(boolean activa) {
		return repo.findByActiva(activa);
	}

}
