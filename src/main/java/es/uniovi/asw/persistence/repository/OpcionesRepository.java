package es.uniovi.asw.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;


public interface OpcionesRepository extends CrudRepository<Opcion, Long> {

	List<Opcion> findByVotacion(Votacion v);

}
