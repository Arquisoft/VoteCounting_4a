package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="TOpcion")
public class Opcion {
	
	Opcion() { }
	
	public Opcion(long long1, String string, long long2) {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Voto> getVotos() {
		return new HashSet<Voto>(votos);
	}
	
	Set<Voto> _getVotos() {
		return votos;
	}
	
	public Votacion getVotacion() {
		return this.votacion;
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
		Opcion other = (Opcion) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}

	public void setVotacion(Votacion votacion) {
		this.votacion = votacion;
	}

	@Id @GeneratedValue
	private long id;
	@OneToMany (mappedBy="opcion")
	private Set<Voto> votos = new HashSet<Voto>();
	@ManyToOne
	private Votacion votacion;
	private String nombre;
}
