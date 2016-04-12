package es.uniovi.asw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "Voto")
public class Voto {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Opcion opcion;
	@ManyToOne
	private ColegioElectoral colegioElectoral;
	@Temporal(TemporalType.DATE)
	private Date fechaVoto;
	@ColumnDefault(value="false")
	private boolean leido;

	public Voto(long long1, java.sql.Date date, long long2, long long3) {
		// TODO Auto-generated constructor stub
	}
	
	public Voto(){}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((colegioElectoral == null) ? 0 : colegioElectoral.hashCode());
		result = prime * result
				+ ((fechaVoto == null) ? 0 : fechaVoto.hashCode());
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
		Voto other = (Voto) obj;
		if (colegioElectoral == null) {
			if (other.colegioElectoral != null)
				return false;
		} else if (!colegioElectoral.equals(other.colegioElectoral))
			return false;
		if (fechaVoto == null) {
			if (other.fechaVoto != null)
				return false;
		} else if (!fechaVoto.equals(other.fechaVoto))
			return false;
		return true;
	}

	public Opcion getOpcion() {
		return opcion;
	}

	void _setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public ColegioElectoral getColegioElectoral() {
		return colegioElectoral;
	}

	void _setColegioElectoral(ColegioElectoral colegioElectoral) {
		this.colegioElectoral = colegioElectoral;
	}

	public long getId() {
		return id;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

}
