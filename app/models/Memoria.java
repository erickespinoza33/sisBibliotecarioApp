package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the MEMORIA database table.
 * 
 */
@Entity
@NamedQuery(name="Memoria.findAll", query="SELECT m FROM Memoria m")
public class Memoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MemoriaPK id;

	@Temporal(TemporalType.DATE)
	private Date fechapublicacion;

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

	public MemoriaPK getId() {
		return this.id;
	}

	public void setId(MemoriaPK id) {
		this.id = id;
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