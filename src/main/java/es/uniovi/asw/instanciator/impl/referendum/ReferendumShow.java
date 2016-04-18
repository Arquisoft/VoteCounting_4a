package es.uniovi.asw.instanciator.impl.referendum;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
//import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

//import com.sun.faces.mgbean.ManagedBeanInfo.MapEntry;

import es.uniovi.asw.conf.VotacionManager;
import es.uniovi.asw.instanciator.VotesShow;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Voto;


public class ReferendumShow extends VotesShow {
	
	public ReferendumShow() {
		super();
		setUpSectChart();
		setUpLineChart();
	}

	private void setUpLineChart() {
		lineChartModel = new LineChartModel();
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

	@Override
	protected void updateChartLine() {
		lineChartModel = new LineChartModel();
		LineChartSeries series;
		for (Opcion o : VotacionManager.getVM().getOpciones()) {
			series = new LineChartSeries();
	        series.setLabel(o.getNombre());
	 
	    //     
	        Map<Date,List<Voto>> grupos = getVotosOpcion(o).stream().sorted(new Comparator<Voto>(){
	        	  public int compare(Voto v1, Voto v2){
	        		    return v1.getFechaVoto().compareTo(v2.getFechaVoto());
	        		  }
	        		}).collect(Collectors.groupingBy(Voto::getFechaVoto));
//	        		
	        for (Map.Entry<Date, List<Voto>> entrada : grupos.entrySet()) {
	        	String dateParaVer= entrada.getKey().toString();
	        	series.set(entrada.getKey().toString(), entrada.getValue().size());
	        }
	        lineChartModel.addSeries(series);
		}
		
//		lineChartModel = new LineChartModel();
//	        LineChartSeries series1 = new LineChartSeries();
//	        series1.setLabel("Series 1");
//	 
//	        series1.set("2014-01-01 20:00", 51);
//	        series1.set("2014-01-06 21:00", 22);
//	        series1.set("2014-01-12 20:04", 65);
//	        series1.set("2014-01-18 21:00", 74);
//	        series1.set("2014-01-24 20:05", 24);
//	        series1.set("2014-01-30 20:05", 51);
//	 
//	        LineChartSeries series2 = new LineChartSeries();
//	        series2.setLabel("Series 2");
//	 
//	        series1.set("2014-01-01 20:00", 65);
//	        series1.set("2014-01-06 21:00", 54);
//	        series1.set("2014-01-12 20:04", 66);
//	        series1.set("2014-01-18 21:00", 30);
//	        series1.set("2014-01-24 20:05", 34);
//	        series1.set("2014-01-30 20:05", 23);
//	 
//	        lineChartModel.addSeries(series1);
	        
		    
	        lineChartModel.setTitle("Zoom for Details");
	        lineChartModel.setZoom(true);
	        lineChartModel.getAxis(AxisType.Y).setLabel("Values");
	        DateAxis axis = new DateAxis("Dates");
	        axis.setTickAngle(-50);
	        axis.setMax("23:59");
	        axis.setTickFormat("%H:%#M");
	         
	        lineChartModel.getAxes().put(AxisType.X, axis);
	}

	private List<Voto> getVotosOpcion(Opcion o) {
		return resultados.stream()
				.filter(v -> v.getOpcion().getId() == o.getId())
				.collect(Collectors.toList());
	}
}
