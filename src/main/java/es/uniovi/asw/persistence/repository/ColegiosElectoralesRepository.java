package es.uniovi.asw.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.ColegioElectoral;


public interface ColegiosElectoralesRepository extends CrudRepository<ColegioElectoral, Long> {

	ColegioElectoral findById(long id);

}
