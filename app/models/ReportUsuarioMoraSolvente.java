package models;

import java.util.Date;

public class ReportUsuarioMoraSolvente {

	String nombre;
	String carnet;
	String telefono;
	String correo;
	String monto;
	Date fechainicio;
	Date fechafin;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	public ReportUsuarioMoraSolvente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportUsuarioMoraSolvente(String nombre, String carnet,
			String telefono, String correo) {
		super();
		this.nombre = nombre;
		this.carnet = carnet;
		this.telefono = telefono;
		this.correo = correo;
	}
	public ReportUsuarioMoraSolvente(String nombre, String carnet, String telefono,
			String correo, String monto, Date fechainicio, Date fechafin) {
		super();
		this.nombre = nombre;
		this.carnet = carnet;
		this.telefono = telefono;
		this.correo = correo;
		this.monto = monto;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
	}
	@Override
	public String toString() {
		return "ReportLibroExsitencia [nombre=" + nombre + ", carnet=" + carnet
				+ ", telefono=" + telefono + ", correo=" + correo + ", monto="
				+ monto + ", fechainicio=" + fechainicio + ", fechafin="
				+ fechafin + "]";
	}
	
}
