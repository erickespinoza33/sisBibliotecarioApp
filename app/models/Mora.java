package models;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;
import play.data.validation.Required;
import play.data.validation.MaxSize;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;


/**
 * The persistent class for the MORA database table.
 * 
 */
@Entity
@Table(name="MORA")
public class Mora extends GenericModel {

	@Id
	@Column(name="IDMORA")
	private long idmora;

	@Column(name="ESTADO")
	private BigDecimal estado;

	@Column(name="FECHAFIN")
	private Date fechafin;

	@Column(name="FECHAINICIO")
	private Date fechainicio;

	@Column(name="MONTO")
	private Float monto;

	@Column(name="TARIFA")
	private Float tarifa;

	//bi-directional many-to-one association to Prestamo
	@ManyToOne
	@JoinColumn(name="IDPRESTAMO")
	private Prestamo prestamo;

	public Mora() {
	}

	public long getIdmora() {
		return this.idmora;
	}

	public void setIdmora(long idmora) {
		this.idmora = idmora;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Float getMonto() {
		return this.monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Float getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(Float tarifa) {
		this.tarifa = tarifa;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

}