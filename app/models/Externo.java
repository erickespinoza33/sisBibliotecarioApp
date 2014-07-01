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
 * The persistent class for the EXTERNO database table.
 * 
 */
@Entity
@Table(name="EXTERNO")
public class Externo extends GenericModel {

	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Id
	@Column(name="CARNET")
	private long carnet;

	@Id
	@Column(name="IDEXTERNO")
	private long idexterno;

	private String lugartrabajo;

	private String profesion;

	//bi-directional many-to-one association to Prestamista
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CARNET", referencedColumnName="CARNET"),
		@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO")
		})
	private Prestamista prestamista;

	//bi-directional many-to-one association to Penalizacion
	@OneToMany(mappedBy="externo")
	private List<Penalizacion> penalizacions;

	public Externo() {
	}
/*
	public ExternoPK getId() {
		return this.id;
	}

	public void setId(ExternoPK id) {
		this.id = id;
	}
*/
	public long getIdexterno() {
		return this.idexterno;
	}
	
	public String getLugartrabajo() {
		return this.lugartrabajo;
	}

	public void setLugartrabajo(String lugartrabajo) {
		this.lugartrabajo = lugartrabajo;
	}

	public String getProfesion() {
		return this.profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
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
		penalizacion.setExterno(this);

		return penalizacion;
	}

	public Penalizacion removePenalizacion(Penalizacion penalizacion) {
		getPenalizacions().remove(penalizacion);
		penalizacion.setExterno(null);

		return penalizacion;
	}
	
	@Override
	public String toString() {
		return "Externo [idUsuario=" + idUsuario + ", carnet=" + carnet
				+ ", idexterno=" + idexterno + ", lugartrabajo=" + lugartrabajo
				+ ", profesion=" + profesion + ", prestamista=" + prestamista
				+ ", penalizacions=" + penalizacions + "]";
	}
	
}