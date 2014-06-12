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
 * The persistent class for the IDIOMA database table.
 * 
 */
@Entity
@Table(name="IDIOMA")
public class Idioma extends GenericModel {

	@Id
	@Column(name="IDIDIOMA")
	private long ididioma;

	@Column(name="NOMBREIDIOMA")
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