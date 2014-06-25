package models;

import java.util.Date;

public class ReportCantidadPrestamos {

	String carnet;
	String nombreusuario;
	String apellidousuario;
	String prestamos;
	Date fechasuscripcion;
	Date fechaexpiracion;
	

	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getApellidousuario() {
		return apellidousuario;
	}
	public void setApellidousuario(String apellidousuario) {
		this.apellidousuario = apellidousuario;
	}
	public String getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(String prestamos) {
		this.prestamos = prestamos;
	}
	public Date getFechasuscripcion() {
		return fechasuscripcion;
	}
	public void setFechasuscripcion(Date fechasuscripcion) {
		this.fechasuscripcion = fechasuscripcion;
	}
	public Date getFechaexpiracion() {
		return fechaexpiracion;
	}
	public void setFechaexpiracion(Date fechaexpiracion) {
		this.fechaexpiracion = fechaexpiracion;
	}
	public ReportCantidadPrestamos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportCantidadPrestamos(String carnet, String nombreusuario, String apellidousuario, String prestamos,
			Date fechasuscripcion, Date fechaexpiracion) {
		super();
		this.carnet = carnet;
		this.nombreusuario = nombreusuario;
		this.apellidousuario = apellidousuario;
		this.prestamos = prestamos;
		this.fechasuscripcion = fechasuscripcion;
		this.fechaexpiracion = fechaexpiracion;
	}
	@Override
	public String toString() {
		return "ReportCantidadPrestamos [carnet=" + carnet
				+ ", nombreusuario=" + nombreusuario + ", apellidousuario=" + apellidousuario 
				+ ", prestamos=" + prestamos
				+ ", fechasuscripcion=" + fechasuscripcion + ", fechaexpiracion="
				+ fechaexpiracion + "]";
	}
	
}
