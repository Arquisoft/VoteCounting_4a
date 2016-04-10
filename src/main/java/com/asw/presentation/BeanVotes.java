package com.asw.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.asw.business.CommandExecutor;
import com.asw.business.FindAllVotes;
import com.asw.model.Voto;
import com.asw.model.exception.BusinessException;

@ManagedBean ()
public class BeanVotes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void prueba (ActionEvent actionEvent) {
		CommandExecutor executor = new CommandExecutor();
		List<Voto> lista;
		try {
			lista = (List<Voto>) executor.execute(new FindAllVotes());
		} catch (BusinessException ex) {
			ex.printStackTrace();
		}
	}
}
