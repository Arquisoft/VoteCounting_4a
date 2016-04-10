package com.asw.presentation;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.asw.conf.ServicesFactory;
import com.asw.model.VotacionDTO;

@ManagedBean(name = "instanciatorBean", eager = true)
@ApplicationScoped
public class InstanciatorBean {

	@PostConstruct
	public void init() {
		System.out.println("BeanInstanciator - INIT");
		cargarTipoVotacion();
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

		switch (vot.getNombre()) {
			case "referendum": {
	
			}
		}
	}
}
