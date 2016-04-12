package es.uniovi.asw.persistence.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.persistence.OpcionesService;
import es.uniovi.asw.persistence.repository.OpcionesRepository;

@Service
public class OpcionesServiceImpl implements OpcionesService {

	@Autowired
	private OpcionesRepository repo;

	@Override
	public List<Opcion> getOpciones(Votacion v) {
		return repo.findByVotacion(v);
	}

}
