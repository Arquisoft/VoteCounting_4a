package com.asw.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.asw.conf.ServicesFactory;
import com.asw.instanciator.AbstractFactory;
import com.asw.instanciator.ReferendumFactory;
import com.asw.instanciator.VotesCalc;
import com.asw.model.VotacionDTO;
import com.asw.model.VotoDTO;

@ManagedBean(name = "instanciatorBean", eager = true)
@ApplicationScoped
public class BeanInstanciator {

	private String pageView;

	@ManagedProperty("#{beanResults}")
	private BeanResults results;
	
	private VotesCalc votesCalc;

	public BeanResults getResults() {
		return results;
	}

	public void setResults(BeanResults results) {
		this.results = results;
	}

	@PostConstruct
	public void init() {
		System.out.println("BeanInstanciator - INIT");
		//cargarTipoVotacion();
	}

	/**
	 * Identifica la votación que está activa y en función de cual sea
	 * instanciará el sistema de una forma u otra.
	 */
	private void cargarTipoVotacion() {
		List<VotacionDTO> votaciones = ServicesFactory.getAdminService()
				.listAllVotaciones();

		VotacionDTO vot = null;
		for (VotacionDTO vdto : votaciones) {
			if (vdto.isActiva()) {
				vot = vdto;
				break;
			}
		}
		if (vot == null) {
			throw new RuntimeException("No hay ninguna votación activa");
		}

		// Indicamos que pagina tiene que ir
		setPageView(vot.getNombre() + ".xhtml");

		AbstractFactory absf;
		switch (vot.getNombre()) {
			case "referendum": {
				absf = new ReferendumFactory();
				break;
			}
			default: {
				throw new RuntimeException("Tipo de votación desconocida");
			}
		}
		this.votesCalc = absf.crearCalc();

		calculoVotosPeriodicos();
	}

	private void calculoVotosPeriodicos() {
		List<VotoDTO> votoscalculados;
		// TODO: llamar a business para bajarse los no leidos

		votoscalculados = new ArrayList<VotoDTO>();

		results.getVotos().addAll(votoscalculados);
		System.out.println("Calculados " + votoscalculados.size()
				+ " votos nuevos");
	}

	public String getPageView() {
		return pageView;
	}

	public void setPageView(String pageView) {
		this.pageView = pageView;
	}

	public VotesCalc getVotesCalc() {
		return votesCalc;
	}

	public void setVotesCalc(VotesCalc votesCalc) {
		this.votesCalc = votesCalc;
	}
}
