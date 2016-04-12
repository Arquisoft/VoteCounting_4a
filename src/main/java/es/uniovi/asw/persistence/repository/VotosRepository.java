package es.uniovi.asw.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Voto;


public interface VotosRepository extends CrudRepository<Voto, Long> {

	List<Voto> findByColegioElectoral(ColegioElectoral cE);
	
	List<Voto> findByLeido(boolean leido);

}
