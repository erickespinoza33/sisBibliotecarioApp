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
 * The persistent class for the CATEGORIAMAPA database table.
 * 
 */
@Entity
@Table(name="CATEGORIAMAPA")
public class Categoriamapa extends GenericModel {

	@Id
	@Column(name="IDCATMAPA")
	private long idcatmapa;

	@Column(name="NOMBRECATMAPA")
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