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
 * The persistent class for the CD database table.
 * 
 */
@Entity
@Table(name="CD")
public class Cd extends GenericModel {

	@Id
	@Column(name="ID")
	private long id;

	@Id
	@Column(name="IDCD")
	private long idcd;

	@Column(name="ALBUM")
	private String album;

	@Column(name="ANO")
	private BigDecimal ano;

	//bi-directional many-to-one association to Artista
	@ManyToOne
	@JoinColumn(name="IDARTISTA")
	private Artista artista;

	//bi-directional many-to-one association to MedioDigital
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID", referencedColumnName="ID"),
		})
	private MedioDigital medioDigital;

	public Cd() {
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