package es.uniovi.asw.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.persistence.VotacionesService;
import es.uniovi.asw.persistence.repository.VotacionesRepository;

@Service
public class VotacionesServiceImpl implements VotacionesService {
	
	@Autowired
	private VotacionesRepository repo;

	@Override
	public Votacion getActive(boolean activa) {
		return repo.findByActiva(activa);
	}

}
