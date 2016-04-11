package com.asw.instanciator.impl.referendum;

import java.util.List;

import com.asw.instanciator.VotesShow;
import com.asw.model.Opcion;
import com.asw.model.Voto;

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
		for (Opcion o : opciones) {
			pieChartModel.getData().put(o.getNombre(), getVotosOpcion(o));
		}
	}

	private int getVotosOpcion(Opcion o) {
		int cont = 0;
		for (Voto v : resultados) {
			if (v.getOpcion() == o.getId())
				cont++;
		}
		return cont;
	}
}
