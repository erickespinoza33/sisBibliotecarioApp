package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the REVISTA database table.
 * 
 */
@Entity
@NamedQuery(name="Revista.findAll", query="SELECT r FROM Revista r")
public class Revista implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RevistaPK id;

	private BigDecimal edicion;

	private String titulo;

	//bi-directional many-to-one association to Hemerografia
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CODIGO", referencedColumnName="CODIGO"),
		@JoinColumn(name="IDMATERIAL", referencedColumnName="IDMATERIAL")
		})
	private Hemerografia hemerografia;

	public Revista() {
	}

	public RevistaPK getId() {
		return this.id;
	}

	public void setId(RevistaPK id) {
		this.id = id;
	}

	public BigDecimal getEdicion() {
		return this.edicion;
	}

	public void setEdicion(BigDecimal edicion) {
		this.edicion = edicion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Hemerografia getHemerografia() {
		return this.hemerografia;
	}

	public void setHemerografia(Hemerografia hemerografia) {
		this.hemerografia = hemerografia;
	}

}