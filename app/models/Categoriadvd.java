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
 * The persistent class for the CATEGORIADVD database table.
 * 
 */
@Entity
@Table(name="CATEGORIADVD")
public class Categoriadvd extends GenericModel {

	@Id
	@Column(name="IDCATDVD")
	private long idcatdvd;

	@Column(name="NOMBRE")
	private String nombre;

	//bi-directional many-to-one association to Dvd
	@OneToMany(mappedBy="categoriadvd")
	private List<Dvd> dvds;

	public Categoriadvd() {
	}

	public long getIdcatdvd() {
		return this.idcatdvd;
	}

	public void setIdcatdvd(long idcatdvd) {
		this.idcatdvd = idcatdvd;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Dvd> getDvds() {
		return this.dvds;
	}

	public void setDvds(List<Dvd> dvds) {
		this.dvds = dvds;
	}

	public Dvd addDvd(Dvd dvd) {
		getDvds().add(dvd);
		dvd.setCategoriadvd(this);

		return dvd;
	}

	public Dvd removeDvd(Dvd dvd) {
		getDvds().remove(dvd);
		dvd.setCategoriadvd(null);

		return dvd;
	}

}