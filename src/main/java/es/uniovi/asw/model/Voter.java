package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Voter {

	@Id @GeneratedValue
	private long id;
	
	@NotNull
	private String nombre;
	@NotNull
	private String password;
	@NotNull
	private String dni;
	@NotNull
	private String email;
	
	private long colegioelectoral;
	
	/**
	 *  Constructor sin parámetros de la clase Voter.
	 */
	public Voter() {}

	/**
	 * Constructor con parámetros de la clase Voter.
	 * @param nombre, nombre del votante.
	 * @param email, email del votante.
	 * @param password, contraseña del votante.
	 * @param dni, documento de identificación del votante.
	 */
	public Voter(String nombre, String email, String password, String dni) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.password =  password;
		this.dni = dni;
	}
	
	/**
	 * Método de acceso a la propiedad nombre de la clase Voter.
	 * @return String con el nombre del votante.
	 */
	public String getNombre() {
		return nombre;
	}

	

	/**
	 * Método de modificación de la propiedad password de la clase voter.
	 * @param password, String con la contraseña del votante.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**	Método de acceso a la propiedad email de la clase Voter.
	 * @return String con el email del votante.
	 */
	public String getEmail() {
		return email;
	}

	

	/**
	 * Método de acceso a la propiedad colegioelectoral de la clase Voter.
	 * @return Long con el numero del colegio electoral correspondiente
	 * al votante.
	 */
	public long getColegioelectoral() {
		return colegioelectoral;
	}

	/**
	 * Método de modificación de la propiedad colegioelectoral de la clase voter.
	 * @param colegioelectoral, Long con el numero del colegio electoral correspondiente
	 * al votante.
	 */
	public void setColegioelectoral(long colegioelectoral) {
		this.colegioelectoral = colegioelectoral;
	}

	/**
	 * Método de acceso al identificador ID de la clase Voter
	 * @return Long con el identificador del votante.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Método de acceso al valor de la propiedad dni de la clase Voter.
	 * @return String con el dni del votante correspondiente.
	 */
	public String getDni() {
		return dni;
	}
	
	public void setDNI(String dni) {
		this.dni = dni;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
}
