package models;

import java.util.Date;

import play.db.jpa.Model;

public class ReportRevistaFecha{

	String categoriamaterial;
	String titulorevista;
	String edicion;
	String nombreeditorial;
	Date fechapublicacion;
	String ubicacion;
	String existencias;
	
	public String getCategoriamaterial() {
		return categoriamaterial;
	}
	public void setCategoriamaterial(String categoriamaterial) {
		this.categoriamaterial = categoriamaterial;
	}
	public String getTitulorevista() {
		return titulorevista;
	}
	public void setTitulorevista(String titulorevista) {
		this.titulorevista = titulorevista;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	public String getNombreeditorial() {
		return nombreeditorial;
	}
	public void setNombreeditorial(String nombreeditorial) {
		this.nombreeditorial = nombreeditorial;
	}
	public Date getFechapublicacion() {
		return fechapublicacion;
	}
	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getExistencias() {
		return existencias;
	}
	public void setExistencias(String existencias) {
		this.existencias = existencias;
	}
	
	public ReportRevistaFecha() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReportRevistaFecha(String categoriamaterial, String titulorevista,
			String edicion, String nombreeditorial, Date fechapublicacion,
			String ubicacion, String existencias) {
		super();
		this.categoriamaterial = categoriamaterial;
		this.titulorevista = titulorevista;
		this.edicion = edicion;
		this.nombreeditorial = nombreeditorial;
		this.fechapublicacion = fechapublicacion;
		this.ubicacion = ubicacion;
		this.existencias = existencias;
	}
	
	@Override
	public String toString() {
		return "ReportRevistaFecha [categoriamaterial=" + categoriamaterial
				+ ", titulorevista=" + titulorevista + ", edicion=" + edicion
				+ ", nombreeditorial=" + nombreeditorial
				+ ", fechapublicacion=" + fechapublicacion + ", ubicacion="
				+ ubicacion + ", existencias=" + existencias + "]";
	}
	
}
