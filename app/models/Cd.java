package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CD database table.
 * 
 */
@Entity
@NamedQuery(name="Cd.findAll", query="SELECT c FROM Cd c")
public class Cd implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CdPK id;

	private String album;

	private BigDecimal ano;

	//bi-directional many-to-one association to Artista
	@ManyToOne
	@JoinColumn(name="IDARTISTA")
	private Artista artista;

	//bi-directional many-to-one association to MedioDigital
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID", referencedColumnName="ID"),
		@JoinColumn(name="IDMATERIAL", referencedColumnName="IDMATERIAL")
		})
	private MedioDigital medioDigital;

	public Cd() {
	}

	public CdPK getId() {
		return this.id;
	}

	public void setId(CdPK id) {
		this.id = id;
	}

	public String getAlbum() {
		return this.album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public BigDecimal getAno() {
		return this.ano;
	}

	public void setAno(BigDecimal ano) {
		this.ano = ano;
	}

	public Artista getArtista() {
		return this.artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public MedioDigital getMedioDigital() {
		return this.medioDigital;
	}

	public void setMedioDigital(MedioDigital medioDigital) {
		this.medioDigital = medioDigital;
	}

}