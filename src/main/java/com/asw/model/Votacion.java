package com.asw.model;

public class Votacion {
	
	public Votacion(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	private long id;
	private String nombre;
	private boolean activa;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
