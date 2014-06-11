package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the OBRA_REFERENCIA database table.
 * 
 */
@Entity
@Table(name="OBRA_REFERENCIA")
@NamedQuery(name="ObraReferencia.findAll", query="SELECT o FROM ObraReferencia o")
public class ObraReferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObraReferenciaPK id;

	private String titulo;

	//bi-directional many-to-many association to Autor
	@ManyToMany
	@JoinTable(
		name="OBRASREF_AUTORES"
		, joinColumns={
			@JoinColumn(name="IDMATERIAL", referencedColumnName="IDMATERIAL"),
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

	public ObraReferenciaPK getId() {
		return this.id;
	}

	public void setId(ObraReferenciaPK id) {
		this.id = id;
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

}