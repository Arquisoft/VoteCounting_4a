package com.asw.presentation;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.asw.model.VotoDTO;
 
@ManagedBean
@ApplicationScoped
public class BeanResults implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
    private List<VotoDTO> votosCalculados;

	public List<VotoDTO> getVotos() {
		return votosCalculados;
	}

	public void setVotos(List<VotoDTO> votos) {
		this.votosCalculados = votos;
	}
     
}