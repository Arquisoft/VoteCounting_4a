package com.asw.model;

import java.util.Date;

public class VotoDTO {

	private long id;
	private Date fecha;
	private long colegio_electoral;
	private long opcion;
	
	
	public VotoDTO(long id, Date fecha, long colegio_electoral, long opcion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.colegio_electoral = colegio_electoral;
		this.opcion = opcion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public long getColegio_electoral() {
		return colegio_electoral;
	}
	public void setColegio_electoral(long colegio_electoral) {
		this.colegio_electoral = colegio_electoral;
	}
	public long getOpcion() {
		return opcion;
	}
	public void setOpcion(long opcion) {
		this.opcion = opcion;
	}
}
