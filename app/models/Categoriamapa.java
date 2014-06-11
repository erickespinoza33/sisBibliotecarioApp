package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORIAMAPA database table.
 * 
 */
@Entity
@NamedQuery(name="Categoriamapa.findAll", query="SELECT c FROM Categoriamapa c")
public class Categoriamapa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idcatmapa;

	private String nombrecatmapa;

	//bi-directional many-to-one association to Mapa
	@OneToMany(mappedBy="categoriamapa")
	private List<Mapa> mapas;

	public Categoriamapa() {
	}

	public long getIdcatmapa() {
		return this.idcatmapa;
	}

	public void setIdcatmapa(long idcatmapa) {
		this.idcatmapa = idcatmapa;
	}

	public String getNombrecatmapa() {
		return this.nombrecatmapa;
	}

	public void setNombrecatmapa(String nombrecatmapa) {
		this.nombrecatmapa = nombrecatmapa;
	}

	public List<Mapa> getMapas() {
		return this.mapas;
	}

	public void setMapas(List<Mapa> mapas) {
		this.mapas = mapas;
	}

	public Mapa addMapa(Mapa mapa) {
		getMapas().add(mapa);
		mapa.setCategoriamapa(this);

		return mapa;
	}

	public Mapa removeMapa(Mapa mapa) {
		getMapas().remove(mapa);
		mapa.setCategoriamapa(null);

		return mapa;
	}

}