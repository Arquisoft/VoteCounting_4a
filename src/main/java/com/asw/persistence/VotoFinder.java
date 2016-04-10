package com.asw.persistence;

import java.util.List;

import com.asw.model.Voto;
import com.asw.persistence.util.Jpa;

/**
 * Clase finder de Veh�culo
 * 
 * @author V�ctor Casta�o Guti�rrez
 *
 */
public class VotoFinder {

	/**
	 * M�todo que devuelve una lista con todos los veh�culos
	 * @return
	 */
	public static List<Voto> findAll() {
		return Jpa.getManager().
				createNamedQuery("Voto.findAll", Voto.class).
				getResultList();
	}

}
