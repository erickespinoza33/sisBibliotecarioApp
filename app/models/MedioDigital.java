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
 * The persistent class for the MEDIO_DIGITAL database table.
 * 
 */
@Entity
@Table(name="MEDIO_DIGITAL")
public class MedioDigital extends GenericModel {

	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="DESCRIPCIONMEDIO")
	private String descripcionmedio;

	//bi-directional many-to-one association to Cd
	@OneToMany(mappedBy="medioDigital")
	private List<Cd> cds;
	//bi-directional many-to-one association to Dvd
	@OneToMany(mappedBy="medioDigital")
	private List<Dvd> dvds;
	//bi-directional many-to-one association to Material
	@ManyToOne
	private Material material;

	public MedioDigital() {
	}

	public String getDescripcionmedio() {
		return this.descripcionmedio;
	}

	public void setDescripcionmedio(String descripcionmedio) {
		this.descripcionmedio = descripcionmedio;
	}

	public List<Cd> getCds() {
		return this.cds;
	}

	public void setCds(List<Cd> cds) {
		this.cds = cds;
	}

	public Cd addCd(Cd cd) {
		getCds().add(cd);
		cd.setMedioDigital(this);

		return cd;
	}

	public Cd removeCd(Cd cd) {
		getCds().remove(cd);
		cd.setMedioDigital(null);

		return cd;
	}

	public List<Dvd> getDvds() {
		return this.dvds;
	}

	public void setDvds(List<Dvd> dvds) {
		this.dvds = dvds;
	}

	public Dvd addDvd(Dvd dvd) {
		getDvds().add(dvd);
		dvd.setMedioDigital(this);

		return dvd;
	}

	public Dvd removeDvd(Dvd dvd) {
		getDvds().remove(dvd);
		dvd.setMedioDigital(null);

		return dvd;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}