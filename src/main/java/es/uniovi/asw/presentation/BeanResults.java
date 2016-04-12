package es.uniovi.asw.presentation;
import java.io.Serializable;
import java.util.List;

import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.instanciator.ReferendumFactory;
import es.uniovi.asw.instanciator.VotesShow;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.impl.GetColegiosElectoralesImpl;
import es.uniovi.asw.persistence.impl.GetVotosImpl;
import es.uniovi.asw.persistence.repository.ColegiosElectoralesRepository;
import es.uniovi.asw.persistence.repository.VotosRepository;
 
@Component("results")
@Scope("application")
public class BeanResults implements Serializable {
	
	private PieChartModel livePieModel;
	private String votoss;
	@Autowired
	VotosRepository repo;
	@Autowired
	ColegiosElectoralesRepository repoCE;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
    private List<Voto> votosCalculados;
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
	
	public PieChartModel  getLivePieModel(){
		ReferendumFactory rf = new ReferendumFactory();
		VotesShow vc = rf.crearShow();
		livePieModel = vc.getLivePieModel();
		return livePieModel;
	}

	public String getVotoss() {
		votoss = "numero de votos : ";
		ColegioElectoral ce = new GetColegiosElectoralesImpl(repoCE).findById(1);
		List<Voto> votar = new GetVotosImpl(repo).getAllVotes(ce);
		for (Voto voto : votar) {
			votoss+=voto.getId();
		}
		return votoss;
	}

	public void setVotoss(String votoss) {
		this.votoss = votoss;
	}


     
}