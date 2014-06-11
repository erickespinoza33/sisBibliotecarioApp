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
 * The persistent class for the ESTUDIANTE database table.
 * 
 */
@Entity
@Table(name="ESTUDIANTE")
public class Estudiante extends GenericModel {

	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Id
	@Column(name="CARNET")
	private long carnet;

	@Id
	@Column(name="IDESTUDIANTE")
	private long idestudiante;

	@Column(name="CARRERA")
	private String carrera;

	//bi-directional many-to-one association to Institucion
	@ManyToOne
	@JoinColumn(name="CODINFRAESTRUCTURA")
	private Institucion institucion;

	//bi-directional many-to-one association to Prestamista
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CARNET", referencedColumnName="CARNET"),
		@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO")
		})
	private Prestamista prestamista;

	//bi-directional many-to-one association to Penalizacion
	@OneToMany(mappedBy="estudiante")
	private List<Penalizacion> penalizacions;

	public Estudiante() {
	}
	/*
	public EstudiantePK getId() {
		return this.id;
	}

	public void setId(EstudiantePK id) {
		this.id = id;
	}
	*/
	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public Prestamista getPrestamista() {
		return this.prestamista;
	}

	public void setPrestamista(Prestamista prestamista) {
		this.prestamista = prestamista;
	}

	public List<Penalizacion> getPenalizacions() {
		return this.penalizacions;
	}

	public void setPenalizacions(List<Penalizacion> penalizacions) {
		this.penalizacions = penalizacions;
	}

	public Penalizacion addPenalizacion(Penalizacion penalizacion) {
		getPenalizacions().add(penalizacion);
		penalizacion.setEstudiante(this);

		return penalizacion;
	}

	public Penalizacion removePenalizacion(Penalizacion penalizacion) {
		getPenalizacions().remove(penalizacion);
		penalizacion.setEstudiante(null);

		return penalizacion;
	}
	
	@Override
	public String toString() {
		return "Estudiante [idUsuario=" + idUsuario + ", carnet=" + carnet
				+ ", idestudiante=" + idestudiante + ", carrera=" + carrera
				+ ", institucion=" + institucion + ", prestamista="
				+ prestamista + ", penalizacions=" + penalizacions + "]";
	}

}