package com.asw.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.asw.conf.ServicesFactory;
import com.asw.instanciator.AbstractFactory;
import com.asw.instanciator.ReferendumFactory;
import com.asw.instanciator.VotesCalc;
import com.asw.model.Votacion;
import com.asw.model.Voto;

@ManagedBean(name = "instanciatorBean", eager = true)
@ApplicationScoped
public class BeanInstanciator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pageView;

	private static final long TIEMPO_MS = 15000;

	@ManagedProperty(value = "#{results}")
	private BeanResults beanResults;

	public BeanResults getBeanResults() {
		return beanResults;
	}

	public void setBeanResults(BeanResults beanResults) {
		this.beanResults = beanResults;
	}

	private VotesCalc votesCalc;

	@PostConstruct
	public void init() {
		System.out.println("BeanInstanciator - INIT");
		beanResults = (BeanResults) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get(new String("beanResults"));
		if (beanResults == null) {
			System.out.println("results - No existia");
			beanResults = new BeanResults();
			FacesContext.getCurrentInstance().getExternalContext()
					.getApplicationMap()
					.put(new String("beanResults"), beanResults);
		}
		cargarTipoVotacion();
	}

	/**
	 * Identifica la votación que está activa y en función de cual sea
	 * instanciará el sistema de una forma u otra.
	 */
	private void cargarTipoVotacion() {
		List<Votacion> votaciones = ServicesFactory.getVotesService()
				.listAllVotaciones();

		Votacion vot = null;
		for (Votacion vdto : votaciones) {
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
		beanResults.setVotesShow(absf.crearShow());
		calculoVotosPeriodicos();
	}

	private void calculoVotosPeriodicos() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				List<Voto> votoscalculados = ServicesFactory.getVotesService()
						.getPendingVotes();
				beanResults.getVotos().addAll(
						votesCalc.calcularResultados(votoscalculados));
				System.out.println("Calculados " + votoscalculados.size()
						+ " votos nuevos");
			}
		};
		timer.schedule(task, 0, TIEMPO_MS);
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
