package es.uniovi.asw.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.instanciator.VotesShow;
import es.uniovi.asw.model.Voto;

@Component("results")
@Scope("application")
public class BeanResults implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Voto> votosCalculados = new ArrayList<Voto>();
	private VotesShow votesShow;

	/**
	 * Metodo para la obtencion de la propiedad votosCalculados.
	 * 
	 * @return Lista con los votos que ya han sido recontados
	 */
	public List<Voto> getVotos() {
		return votosCalculados;
	}

	/**
	 * Metodo para la modificacion de la propiedad votosCalculados.
	 * 
	 * @param votos
	 */
	public void setVotos(List<Voto> votos) {
		this.votosCalculados = votos;
	}

	/**
	 * Metodo para la obtencion de la propiedad votesShow, desde la que se
	 * accedera a las graficas de representacion.
	 * 
	 * @return Objeto votesShow
	 */
	public VotesShow getVotesShow() {
		votesShow.setResults(votosCalculados);
		return votesShow;
	}

	/**
	 * Metodo para la modificacion de la propiedad votesShow.
	 * 
	 * @param votesShow
	 */
	public void setVotesShow(VotesShow votesShow) {
		this.votesShow = votesShow;
	}

}