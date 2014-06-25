package models;

import java.util.Date;

public class ReportUsuariosRegistrados {

	String profesores;
	String estudiantes;
	String externo;
	
	
	public String getProfesores() {
		return profesores;
	}
	public void setProfesores(String profesores) {
		this.profesores = profesores;
	}
	public String getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(String estudiantes) {
		this.estudiantes = estudiantes;
	}
	public String getExterno() {
		return externo;
	}
	public void setExterno(String externo) {
		this.externo = externo;
	}
	public ReportUsuariosRegistrados() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportUsuariosRegistrados(String profesores,
			String estudiantes, String externo) {
		super();
		this.profesores = profesores;
		this.estudiantes = estudiantes;
		this.externo = externo;
		
	}
	@Override
	public String toString() {
		return "ReportUsuariosRegistrado [profesores=" + profesores + ", estudiantes=" + estudiantes
				+ ", externo=" + externo  + "]";
	}
	
}
