package com.asw.instanciator.impl.referendum;

import java.util.List;

import org.primefaces.model.chart.PieChartModel;

import com.asw.conf.ServicesFactory;
import com.asw.instanciator.VotesShow;
import com.asw.model.Opcion;
import com.asw.model.Voto;

public class ReferendumShow extends VotesShow {
	
	public ReferendumShow() {
		opciones = ServicesFactory.getVotesService().getAllOpciones();
		this.pieChartModel = new PieChartModel();
		pieChartModel.setTitle("Votes");
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
