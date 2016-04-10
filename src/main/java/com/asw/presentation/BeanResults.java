package com.asw.presentation;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.asw.instanciator.VotesShow;
import com.asw.model.VotoDTO;
 
@ManagedBean
@ApplicationScoped
public class BeanResults implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
    private List<VotoDTO> votosCalculados;
    private VotesShow votesShow;

	public List<VotoDTO> getVotos() {
		return votosCalculados;
	}

	public void setVotos(List<VotoDTO> votos) {
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