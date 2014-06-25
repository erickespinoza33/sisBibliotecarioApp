package models;

import java.util.Date;

public class ReportPeriodicoFecha {
	
	String categoramaterial;
	String titular;
	String empresa;
	String nombreeditorial;
	Date fechapublicacion;
	String ubicacion;
	String existencias;
	public String getCategoramaterial() {
		return categoramaterial;
	}
	public void setCategoramaterial(String categoramaterial) {
		this.categoramaterial = categoramaterial;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
	
	public ReportPeriodicoFecha() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportPeriodicoFecha(String categoramaterial, String titular,
			String empresa, String nombreeditorial, Date fechapublicacion,
			String ubicacion, String existencias) {
		super();
		this.categoramaterial = categoramaterial;
		this.titular = titular;
		this.empresa = empresa;
		this.nombreeditorial = nombreeditorial;
		this.fechapublicacion = fechapublicacion;
		this.ubicacion = ubicacion;
		this.existencias = existencias;
	}
	@Override
	public String toString() {
		return "ReportPeriodicoFecha [categoramaterial=" + categoramaterial
				+ ", titular=" + titular + ", empresa=" + empresa
				+ ", nombreeditorial=" + nombreeditorial
				+ ", fechapublicacion=" + fechapublicacion + ", ubicacion="
				+ ubicacion + ", existencias=" + existencias + "]";
	}
	

}
