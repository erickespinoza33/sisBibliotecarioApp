package models;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;
import play.data.validation.Required;
import play.data.validation.MaxSize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the DVD database table.
 * 
 */
@Entity
@Table(name="DVD")
public class Dvd extends GenericModel {

	@Id
	@Column(name="ID")
	private long id;
	
	@Id
	@Column(name="IDDVD")
	private long iddvd;

	@Column(name="TITULO")
	private String titulo;

	//bi-directional many-to-one association to Categoriadvd
	@ManyToOne
	@JoinColumn(name="IDCATDVD")
	private Categoriadvd categoriadvd;

	//bi-directional many-to-one association to MedioDigital
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID", referencedColumnName="ID"),
		@JoinColumn(name="IDMATERIAL", referencedColumnName="IDMATERIAL")
		})
	private MedioDigital medioDigital;

	public Dvd() {
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoriadvd getCategoriadvd() {
		return this.categoriadvd;
	}

	public void setCategoriadvd(Categoriadvd categoriadvd) {
		this.categoriadvd = categoriadvd;
	}

	public MedioDigital getMedioDigital() {
		return this.medioDigital;
	}

	public void setMedioDigital(MedioDigital medioDigital) {
		this.medioDigital = medioDigital;
	}

}