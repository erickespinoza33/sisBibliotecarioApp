package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AUTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idautor;

	private String apellidosautor;

	private String direccionautor;

	private String nombresautor;

	private String telefonoautor;

	//bi-directional many-to-many association to Libro
	@ManyToMany(mappedBy="autors")
	private List<Libro> libros;

	//bi-directional many-to-many association to Mapa
	@ManyToMany(mappedBy="autors")
	private List<Mapa> mapas;

	//bi-directional many-to-one association to Memoria
	@OneToMany(mappedBy="autor")
	private List<Memoria> memorias;

	//bi-directional many-to-many association to ObraReferencia
	@ManyToMany(mappedBy="autors")
	private List<ObraReferencia> obraReferencias;

	//bi-directional many-to-many association to TrabajoGraduacion
	@ManyToMany(mappedBy="autors")
	private List<TrabajoGraduacion> trabajoGraduacions;

	public Autor() {
	}

	public long getIdautor() {
		return this.idautor;
	}

	public void setIdautor(long idautor) {
		this.idautor = idautor;
	}

	public String getApellidosautor() {
		return this.apellidosautor;
	}

	public void setApellidosautor(String apellidosautor) {
		this.apellidosautor = apellidosautor;
	}

	public String getDireccionautor() {
		return this.direccionautor;
	}

	public void setDireccionautor(String direccionautor) {
		this.direccionautor = direccionautor;
	}

	public String getNombresautor() {
		return this.nombresautor;
	}

	public void setNombresautor(String nombresautor) {
		this.nombresautor = nombresautor;
	}

	public String getTelefonoautor() {
		return this.telefonoautor;
	}

	public void setTelefonoautor(String telefonoautor) {
		this.telefonoautor = telefonoautor;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public List<Mapa> getMapas() {
		return this.mapas;
	}

	public void setMapas(List<Mapa> mapas) {
		this.mapas = mapas;
	}

	public List<Memoria> getMemorias() {
		return this.memorias;
	}

	public void setMemorias(List<Memoria> memorias) {
		this.memorias = memorias;
	}

	public Memoria addMemoria(Memoria memoria) {
		getMemorias().add(memoria);
		memoria.setAutor(this);

		return memoria;
	}

	public Memoria removeMemoria(Memoria memoria) {
		getMemorias().remove(memoria);
		memoria.setAutor(null);

		return memoria;
	}

	public List<ObraReferencia> getObraReferencias() {
		return this.obraReferencias;
	}

	public void setObraReferencias(List<ObraReferencia> obraReferencias) {
		this.obraReferencias = obraReferencias;
	}

	public List<TrabajoGraduacion> getTrabajoGraduacions() {
		return this.trabajoGraduacions;
	}

	public void setTrabajoGraduacions(List<TrabajoGraduacion> trabajoGraduacions) {
		this.trabajoGraduacions = trabajoGraduacions;
	}

}