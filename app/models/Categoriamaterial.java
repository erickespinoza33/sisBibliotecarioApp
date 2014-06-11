package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORIAMATERIAL database table.
 * 
 */
@Entity
@NamedQuery(name="Categoriamaterial.findAll", query="SELECT c FROM Categoriamaterial c")
public class Categoriamaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idcategoriamat;

	private String categoriamat;

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