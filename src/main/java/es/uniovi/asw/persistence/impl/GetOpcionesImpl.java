package es.uniovi.asw.persistence.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.persistence.GetOpciones;
import es.uniovi.asw.persistence.repository.OpcionesRepository;

public class GetOpcionesImpl implements GetOpciones {

	private final OpcionesRepository repo;
	
	@Autowired
	public GetOpcionesImpl(OpcionesRepository repo)
	{
		this.repo = repo;
	}

	@Override
	public List<Opcion> getOpciones(Votacion v) {
		return repo.findByVotacion(v);
	}



}
