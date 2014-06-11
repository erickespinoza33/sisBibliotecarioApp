package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORIADVD database table.
 * 
 */
@Entity
@NamedQuery(name="Categoriadvd.findAll", query="SELECT c FROM Categoriadvd c")
public class Categoriadvd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idcatdvd;

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