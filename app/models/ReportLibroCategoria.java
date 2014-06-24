package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class ReportLibroCategoria{
	
	@Column(name="DESCRIPCIONCATEGORIA")
	String descripcioncategoria;
	
	@Column(name="UBICACION")
	String ubicacion;
	
	@Column(name="EXISTENCIAS")
	String existencias;
	
	@Column(name="TITULO")
	String titulo;
	
	@Column(name="EDICION")
	String edicion;
	
	@Column(name="VOLUMEN")
	String volumen;

	public String getDescripcioncategoria() {
		return descripcioncategoria;
	}

	public void setDescripcioncategoria(String descripcioncategoria) {
		this.descripcioncategoria = descripcioncategoria;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public ReportLibroCategoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportLibroCategoria(String descripcioncategoria, String ubicacion,
			String existencias, String titulo, String edicion, String volumen) {
		super();
		this.descripcioncategoria = descripcioncategoria;
		this.ubicacion = ubicacion;
		this.existencias = existencias;
		this.titulo = titulo;
		this.edicion = edicion;
		this.volumen = volumen;
	}

	@Override
	public String toString() {
		return "LibroCategoria [descripcioncategoria=" + descripcioncategoria
				+ ", ubicacion=" + ubicacion + ", existencias=" + existencias
				+ ", titulo=" + titulo + ", edicion=" + edicion + ", volumen="
				+ volumen + "]";
	}

	
}
