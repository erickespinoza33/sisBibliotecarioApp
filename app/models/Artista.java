package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ARTISTA database table.
 * 
 */
@Entity
@NamedQuery(name="Artista.findAll", query="SELECT a FROM Artista a")
public class Artista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idartista;

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