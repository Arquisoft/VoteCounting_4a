package es.uniovi.asw.presentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.instanciator.VotesShow;
import es.uniovi.asw.model.Voto;
 
@Component ("results")
@Scope("application")
public class BeanResults implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
    private List<Voto> votosCalculados = new ArrayList<Voto>();
    private VotesShow votesShow;

	public List<Voto> getVotos() {
		return votosCalculados;
	}

	public void setVotos(List<Voto> votos) {
		this.votosCalculados = votos;
	}

	public VotesShow getVotesShow() {
		votesShow.setResults(votosCalculados);
		return votesShow;
	}

	public void setVotesShow(VotesShow votesShow) {
		this.votesShow = votesShow;
	}
     
}