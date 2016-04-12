package es.uniovi.asw.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.ColegiosService;
import es.uniovi.asw.persistence.repository.ColegiosElectoralesRepository;

@Service
public class ColegiosServiceImpl implements ColegiosService {

	@Autowired
	private ColegiosElectoralesRepository repo;
	

	@Override
	public ColegioElectoral findById(long id) {
		return repo.findById(id);
	}

}
