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
 * The persistent class for the MATERIAL database table.
 * 
 */
@Entity
@Table(name="MATERIAL")
public class Material extends GenericModel {

	@Id
	@Column(name="IDMATERIAL")
	private long idmaterial;

	@Column(name="DESCRIPCIONMATERIAL")
	private String descripcionmaterial;

	@Column(name="EXISTENCIAS")
	private BigDecimal existencias;

	@Column(name="UBICACION")
	private String ubicacion;

	//bi-directional many-to-one association to Hemerografia
	@OneToMany(mappedBy="material")
	private List<Hemerografia> hemerografias;

	//bi-directional many-to-one association to Libro
	@OneToMany(mappedBy="material")
	private List<Libro> libros;

	//bi-directional many-to-one association to Mapa
	@OneToMany(mappedBy="material")
	private List<Mapa> mapas;

	//bi-directional many-to-one association to Categoriamaterial
	@ManyToOne
	@JoinColumn(name="IDCATEGORIAMAT")
	private Categoriamaterial categoriamaterial;

	//bi-directional many-to-one association to MedioDigital
	@OneToMany(mappedBy="material")
	private List<MedioDigital> medioDigitals;

	//bi-directional many-to-one association to Memoria
	@OneToMany(mappedBy="material")
	private List<Memoria> memorias;

	//bi-directional many-to-one association to ObraReferencia
	@OneToMany(mappedBy="material")
	private List<ObraReferencia> obraReferencias;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="material")
	private List<Prestamo> prestamos;

	//bi-directional many-to-one association to TrabajoGraduacion
	@OneToMany(mappedBy="material")
	private List<TrabajoGraduacion> trabajoGraduacions;

	public Material() {
	}

	public long getIdmaterial() {
		return this.idmaterial;
	}

	public void setIdmaterial(long idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getDescripcionmaterial() {
		return this.descripcionmaterial;
	}

	public void setDescripcionmaterial(String descripcionmaterial) {
		this.descripcionmaterial = descripcionmaterial;
	}

	public BigDecimal getExistencias() {
		return this.existencias;
	}

	public void setExistencias(BigDecimal existencias) {
		this.existencias = existencias;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Hemerografia> getHemerografias() {
		return this.hemerografias;
	}

	public void setHemerografias(List<Hemerografia> hemerografias) {
		this.hemerografias = hemerografias;
	}

	public Hemerografia addHemerografia(Hemerografia hemerografia) {
		getHemerografias().add(hemerografia);
		hemerografia.setMaterial(this);

		return hemerografia;
	}

	public Hemerografia removeHemerografia(Hemerografia hemerografia) {
		getHemerografias().remove(hemerografia);
		hemerografia.setMaterial(null);

		return hemerografia;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Libro addLibro(Libro libro) {
		getLibros().add(libro);
		libro.setMaterial(this);

		return libro;
	}

	public Libro removeLibro(Libro libro) {
		getLibros().remove(libro);
		libro.setMaterial(null);

		return libro;
	}

	public List<Mapa> getMapas() {
		return this.mapas;
	}

	public void setMapas(List<Mapa> mapas) {
		this.mapas = mapas;
	}

	public Mapa addMapa(Mapa mapa) {
		getMapas().add(mapa);
		mapa.setMaterial(this);

		return mapa;
	}

	public Mapa removeMapa(Mapa mapa) {
		getMapas().remove(mapa);
		mapa.setMaterial(null);

		return mapa;
	}

	public Categoriamaterial getCategoriamaterial() {
		return this.categoriamaterial;
	}

	public void setCategoriamaterial(Categoriamaterial categoriamaterial) {
		this.categoriamaterial = categoriamaterial;
	}

	public List<MedioDigital> getMedioDigitals() {
		return this.medioDigitals;
	}

	public void setMedioDigitals(List<MedioDigital> medioDigitals) {
		this.medioDigitals = medioDigitals;
	}

	public MedioDigital addMedioDigital(MedioDigital medioDigital) {
		getMedioDigitals().add(medioDigital);
		medioDigital.setMaterial(this);

		return medioDigital;
	}

	public MedioDigital removeMedioDigital(MedioDigital medioDigital) {
		getMedioDigitals().remove(medioDigital);
		medioDigital.setMaterial(null);

		return medioDigital;
	}

	public List<Memoria> getMemorias() {
		return this.memorias;
	}

	public void setMemorias(List<Memoria> memorias) {
		this.memorias = memorias;
	}

	public Memoria addMemoria(Memoria memoria) {
		getMemorias().add(memoria);
		memoria.setMaterial(this);

		return memoria;
	}

	public Memoria removeMemoria(Memoria memoria) {
		getMemorias().remove(memoria);
		memoria.setMaterial(null);

		return memoria;
	}

	public List<ObraReferencia> getObraReferencias() {
		return this.obraReferencias;
	}

	public void setObraReferencias(List<ObraReferencia> obraReferencias) {
		this.obraReferencias = obraReferencias;
	}

	public ObraReferencia addObraReferencia(ObraReferencia obraReferencia) {
		getObraReferencias().add(obraReferencia);
		obraReferencia.setMaterial(this);

		return obraReferencia;
	}

	public ObraReferencia removeObraReferencia(ObraReferencia obraReferencia) {
		getObraReferencias().remove(obraReferencia);
		obraReferencia.setMaterial(null);

		return obraReferencia;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo addPrestamo(Prestamo prestamo) {
		getPrestamos().add(prestamo);
		prestamo.setMaterial(this);

		return prestamo;
	}

	public Prestamo removePrestamo(Prestamo prestamo) {
		getPrestamos().remove(prestamo);
		prestamo.setMaterial(null);

		return prestamo;
	}

	public List<TrabajoGraduacion> getTrabajoGraduacions() {
		return this.trabajoGraduacions;
	}

	public void setTrabajoGraduacions(List<TrabajoGraduacion> trabajoGraduacions) {
		this.trabajoGraduacions = trabajoGraduacions;
	}

	public TrabajoGraduacion addTrabajoGraduacion(TrabajoGraduacion trabajoGraduacion) {
		getTrabajoGraduacions().add(trabajoGraduacion);
		trabajoGraduacion.setMaterial(this);

		return trabajoGraduacion;
	}

	public TrabajoGraduacion removeTrabajoGraduacion(TrabajoGraduacion trabajoGraduacion) {
		getTrabajoGraduacions().remove(trabajoGraduacion);
		trabajoGraduacion.setMaterial(null);

		return trabajoGraduacion;
	}

}