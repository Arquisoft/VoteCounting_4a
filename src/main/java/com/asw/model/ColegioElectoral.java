package com.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "TColegioElectoral")
public class ColegioElectoral {
	
	ColegioElectoral() { }
	
	public long getIdent() {
		return ident;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	Set<Votante> _getVotantes() {
		return votantes;
	}
	
	public Set<Votante> getVotantes() {
		return new HashSet<Votante>(votantes);
	}
	
	public Set<Voto> getVotos() {
		return new HashSet<Voto>(votos);
	}

	Set<Voto> _getVotos() {
		return votos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ident ^ (ident >>> 32));
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
		ColegioElectoral other = (ColegioElectoral) obj;
		if (ident != other.ident)
			return false;
		return true;
	}

	@Id @GeneratedValue
	private long id;
	private long ident;
	private String nombre;
	@OneToMany (mappedBy="colegioElectoral")
	private Set<Votante> votantes = new HashSet<Votante>();
	@OneToMany (mappedBy="colegioElectoral")
	private Set<Voto> votos = new HashSet<Voto>();
}
