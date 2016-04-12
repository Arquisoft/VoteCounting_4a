package es.uniovi.asw.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Votacion;


public interface VotacionesRepository extends CrudRepository<Votacion, Long> {

	Votacion findByActiva(boolean activa);

}
