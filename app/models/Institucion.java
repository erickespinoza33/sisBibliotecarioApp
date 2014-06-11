package models;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;
import play.data.validation.Required;
import play.data.validation.MaxSize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the INSTITUCION database table.
 * 
 */
@Entity
@Table(name="INSTITUCION")
public class Institucion extends GenericModel {
	
	@Id
	@Column(name="CODINFRAESTRUCTURA")
	private long codinfraestructura;

	@Column(name="DIRECCIONINSTITUCION")
	private String direccioninstitucion;

	@Column(name="NOMBREINSTITUCION")
	private String nombreinstitucion;

	@Column(name="TELEFONOINSTITUCION")
	private String telefonoinstitucion;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="institucion")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="institucion")
	private List<Profesor> profesors;

	public Institucion() {
	}

	public long getCodinfraestructura() {
		return this.codinfraestructura;
	}

	public void setCodinfraestructura(long codinfraestructura) {
		this.codinfraestructura = codinfraestructura;
	}

	public String getDireccioninstitucion() {
		return this.direccioninstitucion;
	}

	public void setDireccioninstitucion(String direccioninstitucion) {
		this.direccioninstitucion = direccioninstitucion;
	}

	public String getNombreinstitucion() {
		return this.nombreinstitucion;
	}

	public void setNombreinstitucion(String nombreinstitucion) {
		this.nombreinstitucion = nombreinstitucion;
	}

	public String getTelefonoinstitucion() {
		return this.telefonoinstitucion;
	}

	public void setTelefonoinstitucion(String telefonoinstitucion) {
		this.telefonoinstitucion = telefonoinstitucion;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setInstitucion(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setInstitucion(null);

		return estudiante;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setInstitucion(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setInstitucion(null);

		return profesor;
	}

	@Override
	public String toString() {
		return "Institucion [codinfraestructura=" + codinfraestructura
				+ ", direccioninstitucion=" + direccioninstitucion
				+ ", nombreinstitucion=" + nombreinstitucion
				+ ", telefonoinstitucion=" + telefonoinstitucion
				+ ", estudiantes=" + estudiantes + ", profesors=" + profesors
				+ "]";
	}
	
}