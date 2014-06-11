package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EDITORIAL database table.
 * 
 */
@Entity
@NamedQuery(name="Editorial.findAll", query="SELECT e FROM Editorial e")
public class Editorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long ideditorial;

	private String direccioneditorial;

	private String nombreeditorial;

	private String telefonoeditorial;

	//bi-directional many-to-one association to Hemerografia
	@OneToMany(mappedBy="editorial")
	private List<Hemerografia> hemerografias;

	//bi-directional many-to-one association to Libro
	@OneToMany(mappedBy="editorial")
	private List<Libro> libros;

	public Editorial() {
	}

	public long getIdeditorial() {
		return this.ideditorial;
	}

	public void setIdeditorial(long ideditorial) {
		this.ideditorial = ideditorial;
	}

	public String getDireccioneditorial() {
		return this.direccioneditorial;
	}

	public void setDireccioneditorial(String direccioneditorial) {
		this.direccioneditorial = direccioneditorial;
	}

	public String getNombreeditorial() {
		return this.nombreeditorial;
	}

	public void setNombreeditorial(String nombreeditorial) {
		this.nombreeditorial = nombreeditorial;
	}

	public String getTelefonoeditorial() {
		return this.telefonoeditorial;
	}

	public void setTelefonoeditorial(String telefonoeditorial) {
		this.telefonoeditorial = telefonoeditorial;
	}

	public List<Hemerografia> getHemerografias() {
		return this.hemerografias;
	}

	public void setHemerografias(List<Hemerografia> hemerografias) {
		this.hemerografias = hemerografias;
	}

	public Hemerografia addHemerografia(Hemerografia hemerografia) {
		getHemerografias().add(hemerografia);
		hemerografia.setEditorial(this);

		return hemerografia;
	}

	public Hemerografia removeHemerografia(Hemerografia hemerografia) {
		getHemerografias().remove(hemerografia);
		hemerografia.setEditorial(null);

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
		libro.setEditorial(this);

		return libro;
	}

	public Libro removeLibro(Libro libro) {
		getLibros().remove(libro);
		libro.setEditorial(null);

		return libro;
	}

}