package es.uniovi.asw.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.GetColegiosElectorales;
import es.uniovi.asw.persistence.repository.ColegiosElectoralesRepository;

public class GetColegiosElectoralesImpl implements GetColegiosElectorales {

	private final ColegiosElectoralesRepository repo;
	
	@Autowired
	public GetColegiosElectoralesImpl(ColegiosElectoralesRepository repo)
	{
		this.repo = repo;
	}

	@Override
	public ColegioElectoral findById(long id) {
		return repo.findById(id);
	}

}
