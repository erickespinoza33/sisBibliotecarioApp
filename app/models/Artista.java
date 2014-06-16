package models;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;
import play.data.validation.Required;
import play.data.validation.MaxSize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the ARTISTA database table.
 * 
 */
@Entity
@Table(name="ARTISTA")
public class Artista extends GenericModel {

	@Id
	@Column(name="IDARTISTA")
	private long idartista;

	@Column(name="NOMBREARTISTA")
	private String nombreartista;

	//bi-directional many-to-one association to Cd
	@OneToMany(mappedBy="artista")
	private List<Cd> cds;

	public Artista() {
	}

	public long getIdartista() {
		return this.idartista;
	}

	public void setIdartista(long idartista) {
		this.idartista = idartista;
	}

	public String getNombreartista() {
		return this.nombreartista;
	}

	public void setNombreartista(String nombreartista) {
		this.nombreartista = nombreartista;
	}

	public List<Cd> getCds() {
		return this.cds;
	}

	public void setCds(List<Cd> cds) {
		this.cds = cds;
	}

	public Cd addCd(Cd cd) {
		getCds().add(cd);
		cd.setArtista(this);

		return cd;
	}

	public Cd removeCd(Cd cd) {
		getCds().remove(cd);
		cd.setArtista(null);

		return cd;
	}

}