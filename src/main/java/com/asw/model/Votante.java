package com.asw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="TVotante")
public class Votante {
	
	Votante () { }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean isVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}

	public String getNIF() {
		return NIF;
	}

	public ColegioElectoral getColegioElectoral() {
		return colegioElectoral;
	}

	void _setColegioElectoral(ColegioElectoral colegioElectoral) {
		this.colegioElectoral = colegioElectoral;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NIF == null) ? 0 : NIF.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Votante other = (Votante) obj;
		if (NIF == null) {
			if (other.NIF != null)
				return false;
		} else if (!NIF.equals(other.NIF))
			return false;
		return true;
	}



	@Id
	private String NIF;
	private String nombre;
	private String apellidos;
	private boolean voto;
	
	@ManyToOne
	private ColegioElectoral colegioElectoral;
	
	
}
