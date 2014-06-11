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
 * The persistent class for the MEMORIA database table.
 * 
 */
@Entity
@Table(name="MEMORIA")
public class Memoria extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDMEMORIA")
	private long idMemoria;

	@Column(name="FECHAPUBLICACION")
	private Date fechapublicacion;

	@Column(name="TITULO")
	private String titulo;

	//bi-directional many-to-one association to Autor
	@ManyToOne
	@JoinColumn(name="IDAUTOR")
	private Autor autor;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="IDMATERIAL")
	private Material material;

	public Memoria() {
	}

	public Date getFechapublicacion() {
		return this.fechapublicacion;
	}

	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}