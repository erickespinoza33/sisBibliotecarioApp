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
 * The persistent class for the CATEGORIAMATERIAL database table.
 * 
 */
@Entity
@Table(name="CATEGORIAMATERIAL")
public class Categoriamaterial extends GenericModel {

	@Id
	@Column(name="IDCATEGORIAMAT")
	private long idcategoriamat;

	@Column(name="CATEGORIAMAT")
	private String categoriamat;

	@Column(name="DESCRIPCIONCATEGORIA")
	private String descripcioncategoria;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="categoriamaterial")
	private List<Material> materials;

	public Categoriamaterial() {
	}

	public long getIdcategoriamat() {
		return this.idcategoriamat;
	}

	public void setIdcategoriamat(long idcategoriamat) {
		this.idcategoriamat = idcategoriamat;
	}

	public String getCategoriamat() {
		return this.categoriamat;
	}

	public void setCategoriamat(String categoriamat) {
		this.categoriamat = categoriamat;
	}

	public String getDescripcioncategoria() {
		return this.descripcioncategoria;
	}

	public void setDescripcioncategoria(String descripcioncategoria) {
		this.descripcioncategoria = descripcioncategoria;
	}

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setCategoriamaterial(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setCategoriamaterial(null);

		return material;
	}

}