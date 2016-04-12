package es.uniovi.asw.instanciator.impl.referendum;

import java.util.List;
import java.util.stream.Collectors;

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
			pieChartModel.getData().put(o.getNombre(), getVotosOpcion(o).size());
		}
	}

	private List<Voto> getVotosOpcion(Opcion o) {
		return resultados.stream()
				.filter(v -> v.getOpcion().getId() == o.getId())
				.collect(Collectors.toList());
	}
}
