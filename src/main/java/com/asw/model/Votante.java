package com.asw.model;

public class Votante {

	private String nif;
	private String apellidos;
	private String nombre;
	private boolean voto;
	private long colegioElectoral_Id;

	public Votante(String nif, String apellidos, String nombre, boolean voto,
			long colegioElectoral_Id) {
		this.nif=nif;
		this.apellidos=apellidos;
		this.nombre=nombre;
		this.voto=voto;
		this.colegioElectoral_Id=colegioElectoral_Id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}

	public long getColegioElectoral_Id() {
		return colegioElectoral_Id;
	}

	public void setColegioElectoral_Id(long colegioElectoral_Id) {
		this.colegioElectoral_Id = colegioElectoral_Id;
	}

}
