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
 * The persistent class for the PENALIZACION database table.
 * 
 */
@Entity
@Table(name="PENALIZACION")
public class Penalizacion extends GenericModel {

	@Id
	@Column(name="IDPENALIZACION")
	private long idpenalizacion;

	@Column(name="DESCRIPCIONPENALIZACION")
	private String descripcionpenalizacion;

	@Column(name="ESTADO")
	private BigDecimal estado;

	@Column(name="FECHAINICIO")
	private Date fechainicio;

	@Column(name="TIEMPO")
	private Date tiempo;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CARNET", referencedColumnName="CARNET"),
		@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO"),
		@JoinColumn(name="IDESTUDIANTE", referencedColumnName="IDESTUDIANTE")
		})
	private Estudiante estudiante;

	//bi-directional many-to-one association to Externo
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="EXT_CARNET", referencedColumnName="CARNET"),
		@JoinColumn(name="EXT_ID_USUARIO", referencedColumnName="ID_USUARIO"),
		@JoinColumn(name="IDEXTERNO", referencedColumnName="IDEXTERNO")
		})
	private Externo externo;

	public Penalizacion() {
	}

	public long getIdpenalizacion() {
		return this.idpenalizacion;
	}

	public void setIdpenalizacion(long idpenalizacion) {
		this.idpenalizacion = idpenalizacion;
	}

	public String getDescripcionpenalizacion() {
		return this.descripcionpenalizacion;
	}

	public void setDescripcionpenalizacion(String descripcionpenalizacion) {
		this.descripcionpenalizacion = descripcionpenalizacion;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Externo getExterno() {
		return this.externo;
	}

	public void setExterno(Externo externo) {
		this.externo = externo;
	}

	@Override
	public String toString() {
		return "Penalizacion [idpenalizacion=" + idpenalizacion
				+ ", descripcionpenalizacion=" + descripcionpenalizacion
				+ ", estado=" + estado + ", fechainicio=" + fechainicio
				+ ", tiempo=" + tiempo + "]";
	}

}