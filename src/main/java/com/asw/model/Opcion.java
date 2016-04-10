package com.asw.model;

public class Opcion {

	private long id;
	private String nombre;
	private long votacion_id;
	
	public Opcion(long id, String nombre, long votacion_id) {
		this.id = id;
		this.nombre = nombre;
		this.votacion_id = votacion_id;
	}
	
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
	public long getVotacion_id() {
		return votacion_id;
	}
	public void setVotacion_id(long votacion_id) {
		this.votacion_id = votacion_id;
	}
	
	

}
