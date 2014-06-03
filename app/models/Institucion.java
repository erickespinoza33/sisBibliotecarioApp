package models;

import play.db.jpa.GenericModel;

public class Institucion extends GenericModel {
	private String nombreInstitucion;
	private String telefonoInstitucion;
	private String direccionInstitucion;
	
	public String getNombreInstitucion() {
		return nombreInstitucion;
	}
	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}
	public String getTelefonoInstitucion() {
		return telefonoInstitucion;
	}
	public void setTelefonoInstitucion(String telefonoInstitucion) {
		this.telefonoInstitucion = telefonoInstitucion;
	}
	public String getDireccionInstitucion() {
		return direccionInstitucion;
	}
	public void setDireccionInstitucion(String direccionInstitucion) {
		this.direccionInstitucion = direccionInstitucion;
	}
	
	@Override
	public String toString() {
		return "Institucion [nombreInstitucion=" + nombreInstitucion
				+ ", telefonoInstitucion=" + telefonoInstitucion
				+ ", direccionInstitucion=" + direccionInstitucion + "]";
	}
	

}
