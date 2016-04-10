package com.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TVotacion")
public class Votacion{

	Votacion() {}
	
	@Id @GeneratedValue
	private long id;
	private String nombre;
	@OneToMany (mappedBy = "votacion")
	private Set<Opcion> opciones = new HashSet<Opcion>();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	Set<Opcion> _getOpciones() {
		return opciones;
	}
	
	public Set<Opcion> getOpciones() {
		return new HashSet<Opcion>(opciones);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Votacion other = (Votacion) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
