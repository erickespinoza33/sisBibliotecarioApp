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
 * The persistent class for the OBRA_REFERENCIA database table.
 * 
 */
@Entity
@Table(name="OBRA_REFERENCIA")
public class ObraReferencia extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDOBRAREF")
	private long idobraref;
	
	@Column(name="TITULO")
	private String titulo;

	//bi-directional many-to-many association to Autor
	@ManyToMany
	@JoinTable(
		name="OBRASREF_AUTORES"
		, joinColumns={
			@JoinColumn(name="IDOBRAREF", referencedColumnName="IDOBRAREF")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDAUTOR")
			}
		)
	private List<Autor> autors;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="IDMATERIAL")
	private Material material;

	//bi-directional many-to-one association to Tipoobrareferencia
	@ManyToOne
	@JoinColumn(name="IDTIPOOBRAREF")
	private Tipoobrareferencia tipoobrareferencia;

	public ObraReferencia() {
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

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Tipoobrareferencia getTipoobrareferencia() {
		return this.tipoobrareferencia;
	}

	public void setTipoobrareferencia(Tipoobrareferencia tipoobrareferencia) {
		this.tipoobrareferencia = tipoobrareferencia;
	}
	
	public long getIdobraref(){
		return idobraref;
	}
	
	public void setIdobraref(long idobraref){
		this.idobraref = idobraref;
	}

}