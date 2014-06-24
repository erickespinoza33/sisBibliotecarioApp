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
 * The persistent class for the LIBRO database table.
 * 
 */
@Entity
@Table(name="LIBRO")
public class Libro extends GenericModel {

	@Id
	@Column(name="ISBN")
	private long isbn;

	@Column(name="COSTO")
	private BigDecimal costo;

	@Column(name="DONADO")
	private BigDecimal donado;

	@Column(name="EDICION")
	private BigDecimal edicion;

	@Column(name="LOGO")
	private String logo;

	@Column(name="TITULO")
	private String titulo;

	@Column(name="VOLUMEN")
	private BigDecimal volumen;

	//bi-directional many-to-many association to Autor
	@ManyToMany
	@JoinTable(
		name="LIBROS_AUTOR"
		, joinColumns={
			@JoinColumn(name="ISBN", referencedColumnName="ISBN")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDAUTOR")
			}
		)
	private List<Autor> autors;

	//bi-directional many-to-one association to Editorial
	@ManyToOne
	@JoinColumn(name="IDEDITORIAL")
	private Editorial editorial;

	//bi-directional many-to-many association to Idioma
	@ManyToMany
	@JoinTable(
		name="LIBROS_IDIOMAS"
		, joinColumns={
			@JoinColumn(name="ISBN", referencedColumnName="ISBN")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDIDIOMA")
			}
		)
	private List<Idioma> idiomas;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="IDMATERIAL")
	private Material material;

	public Libro() {
	}

	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public BigDecimal getDonado() {
		return this.donado;
	}

	public void setDonado(BigDecimal donado) {
		this.donado = donado;
	}

	public BigDecimal getEdicion() {
		return this.edicion;
	}

	public void setEdicion(BigDecimal edicion) {
		this.edicion = edicion;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getVolumen() {
		return this.volumen;
	}

	public void setVolumen(BigDecimal volumen) {
		this.volumen = volumen;
	}

	public List<Autor> getAutors() {
		return this.autors;
	}

	public void setAutors(List<Autor> autors) {
		this.autors = autors;
	}

	public Editorial getEditorial() {
		return this.editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public List<Idioma> getIdiomas() {
		return this.idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	public long getISBN() {
		return this.isbn;
	}

}