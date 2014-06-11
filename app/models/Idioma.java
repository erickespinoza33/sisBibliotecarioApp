package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the IDIOMA database table.
 * 
 */
@Entity
@NamedQuery(name="Idioma.findAll", query="SELECT i FROM Idioma i")
public class Idioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long ididioma;

	private String nombreidioma;

	//bi-directional many-to-many association to Libro
	@ManyToMany(mappedBy="idiomas")
	private List<Libro> libros;

	public Idioma() {
	}

	public long getIdidioma() {
		return this.ididioma;
	}

	public void setIdidioma(long ididioma) {
		this.ididioma = ididioma;
	}

	public String getNombreidioma() {
		return this.nombreidioma;
	}

	public void setNombreidioma(String nombreidioma) {
		this.nombreidioma = nombreidioma;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}