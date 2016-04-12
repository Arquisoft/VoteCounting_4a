package es.uniovi.asw.instanciator.impl.referendum;

import java.util.List;

import es.uniovi.asw.conf.VotacionManager;
import es.uniovi.asw.instanciator.VotesShow;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Voto;


public class ReferendumShow extends VotesShow {
	
	public ReferendumShow() {
		super();
		setUpSectChart();
	}

	private void setUpSectChart() {
		pieChartModel.setFill(false);
		pieChartModel.setShowDataLabels(true);
		pieChartModel.setTitle("Referendum - SECTORES");
		pieChartModel.setLegendPosition("ne");
	}

	@Override
	public void setResults(List<Voto> results) {
		setResultados(results);
	}
	
	@Override
	protected void updateChartLive() {
		for (Opcion o : VotacionManager.getVM().getOpciones()) {
			pieChartModel.getData().put(o.getNombre(), getVotosOpcion(o));
		}
	}

	private int getVotosOpcion(Opcion o) {
		int cont = 0;
		for (Voto v : resultados) {
			if (v.getOpcion().getId() == o.getId())
				cont++;
		}
		return cont;
	}
}
