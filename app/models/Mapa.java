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
 * The persistent class for the MAPA database table.
 * 
 */
@Entity
@Table(name="MAPA")
public class Mapa extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDMAPA")
	private long idmapa;
	
	@Column(name="ESCALA")
	private String escala;

	@Column(name="FUENTE")
	private String fuente;

	@Column(name="LUGAR")
	private String lugar;

	@Column(name="TITULO")
	private String titulo;

	//bi-directional many-to-many association to Autor
	@ManyToMany
	@JoinTable(
		name="MAPAS_AUTORES"
		, joinColumns={
			@JoinColumn(name="IDMAPA", referencedColumnName="IDMAPA"),
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDAUTOR")
			}
		)
	private List<Autor> autors;

	//bi-directional many-to-one association to Categoriamapa
	@ManyToOne
	@JoinColumn(name="IDCATMAPA")
	private Categoriamapa categoriamapa;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="IDMATERIAL")
	private Material material;

	public Mapa() {
	}

	public String getEscala() {
		return this.escala;
	}

	public void setEscala(String escala) {
		this.escala = escala;
	}

	public String getFuente() {
		return this.fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Autor> getAutors() {
		return this.autors;
	}

	public void setAutors(List<Autor> autors) {
		this.autors = autors;
	}

	public Categoriamapa getCategoriamapa() {
		return this.categoriamapa;
	}

	public void setCategoriamapa(Categoriamapa categoriamapa) {
		this.categoriamapa = categoriamapa;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}