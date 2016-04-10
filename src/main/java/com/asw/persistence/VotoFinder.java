package com.asw.persistence;

import java.util.List;

import com.asw.model.Voto;
import com.asw.persistence.util.Jpa;

public class VotoFinder {
	
	public static List<Voto> findAll() {
		return Jpa.getManager().
				createQuery("select v from " + Voto.class.getName() + " v", Voto.class).
				getResultList();
	}

}
