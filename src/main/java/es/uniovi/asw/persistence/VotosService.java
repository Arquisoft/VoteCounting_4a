package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Voto;

public interface VotosService {
	
	List<Voto> getAllVotes(ColegioElectoral ce);
	
	void updateLeido(Voto v);
	
	List<Voto> votosLeidos(boolean leido);

}
