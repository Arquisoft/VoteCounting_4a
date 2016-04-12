package es.uniovi.asw.persistence.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.VotosService;
import es.uniovi.asw.persistence.repository.VotosRepository;

@Service
public class VotosServiceImpl implements VotosService {
	
	@Autowired
	private VotosRepository repo;
	

	@Override
	public List<Voto> getAllVotes(ColegioElectoral ce) {
		return repo.findByColegioElectoral(ce);
	}

	@Override
	public void updateLeido(Voto v) {
		repo.save(v);
	}

	@Override
	public List<Voto> votosLeidos(boolean leido) {
		return repo.findByLeido(leido);
	}

}
