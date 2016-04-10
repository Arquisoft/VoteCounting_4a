package com.asw.model;

public class ColegioElectoral {

	private long id;
	private long ident;
	private String nombre;

	public ColegioElectoral(long id, long ident, String nombre) {
		this.id = id;
		this.ident = ident;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdent() {
		return ident;
	}

	public void setIdent(long ident) {
		this.ident = ident;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
