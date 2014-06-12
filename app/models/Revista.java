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
 * The persistent class for the REVISTA database table.
 * 
 */
@Entity
@Table(name="REVISTA")
public class Revista extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDREVISTA")
	private long idrevista;
	
	@Column(name="EDICICON")
	private BigDecimal edicion;

	@Column(name="TITULO")
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