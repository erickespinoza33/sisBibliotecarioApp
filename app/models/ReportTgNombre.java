package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class ReportTgNombre{
	
	@Column(name="TEMA")
	String tema;
	
	@Column(name="FECHAARCHIVADO")
	Date fechaarchivado;
	
	@Column(name="ASESOR")
	String asesor;
	
	@Column(name="NOMBRESAUTOR")
	String nombresautor;
	
	@Column(name="APELLIDOSAUTOR")
	String apellidosautor;
	
	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Date getFechaarchivado() {
		return fechaarchivado;
	}

	public void setFechaarchivado(Date fechaarchivado) {
		this.fechaarchivado = fechaarchivado;
	}

	public String getAsesor() {
		return asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public String getNombresautor() {
		return nombresautor;
	}

	public void setNombresautor(String nombresautor) {
		this.nombresautor = nombresautor;
	}

	public String getApellidosautor() {
		return apellidosautor;
	}

	public void setApellidosautor(String apellidosautor) {
		this.apellidosautor = apellidosautor;
	}

	public ReportTgNombre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportTgNombre(String tema, Date fechaarchivado,
			String asesor, String nombresautor, String apellidosautor) {
		super();
		this.tema = tema;
		this.fechaarchivado = fechaarchivado;
		this.asesor = asesor;
		this.nombresautor = nombresautor;
		this.apellidosautor = apellidosautor;
	
	}

	@Override
	public String toString() {
		return "tg_por_nombre [tema=" + tema
				+ ", fechaarchivado=" + fechaarchivado + ", asesor=" + asesor
				+ ", nombresautor=" + nombresautor + ", apellidosautor=" + apellidosautor + "]";
	}

	
}
