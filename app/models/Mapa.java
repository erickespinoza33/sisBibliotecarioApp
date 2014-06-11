package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MAPA database table.
 * 
 */
@Entity
@NamedQuery(name="Mapa.findAll", query="SELECT m FROM Mapa m")
public class Mapa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MapaPK id;

	private String escala;

	private String fuente;

	private String lugar;

	private String titulo;

	//bi-directional many-to-many association to Autor
	@ManyToMany
	@JoinTable(
		name="MAPAS_AUTORES"
		, joinColumns={
			@JoinColumn(name="IDMAPA", referencedColumnName="IDMAPA"),
			@JoinColumn(name="IDMATERIAL", referencedColumnName="IDMATERIAL")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDAUTOR")
			}
		)
	private List<Autor> autors;

	//bi-directional many-to-one association to Categoriamapa
	@ManyToOne
	@JoinColumn(name="IDCATMAPA")
	private Categoriamapa categoriamapa;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="IDMATERIAL")
	private Material material;

	public Mapa() {
	}

	public MapaPK getId() {
		return this.id;
	}

	public void setId(MapaPK id) {
		this.id = id;
	}

	public String getEscala() {
		return this.escala;
	}

	public void setEscala(String escala) {
		this.escala = escala;
	}

	public String getFuente() {
		return this.fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
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

	public Categoriamapa getCategoriamapa() {
		return this.categoriamapa;
	}

	public void setCategoriamapa(Categoriamapa categoriamapa) {
		this.categoriamapa = categoriamapa;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}