package com.asw.presentation;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;
 
@ManagedBean
public class ChartView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PieChartModel livePieModel;
 
    public PieChartModel getLivePieModel() {
        int random1 = (int)(Math.random() * 1000);
        int random2 = (int)(Math.random() * 1000);
        this.livePieModel = new PieChartModel();
 
        livePieModel.getData().put("Candidate 1", random1);
        livePieModel.getData().put("Candidate 2", random2);
         
        livePieModel.setTitle("Votes");
        livePieModel.setLegendPosition("ne");
         
        return livePieModel;
    }
     
}