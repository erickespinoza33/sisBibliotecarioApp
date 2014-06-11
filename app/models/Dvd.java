package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DVD database table.
 * 
 */
@Entity
@NamedQuery(name="Dvd.findAll", query="SELECT d FROM Dvd d")
public class Dvd implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DvdPK id;

	private String titulo;

	//bi-directional many-to-one association to Categoriadvd
	@ManyToOne
	@JoinColumn(name="IDCATDVD")
	private Categoriadvd categoriadvd;

	//bi-directional many-to-one association to MedioDigital
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID", referencedColumnName="ID"),
		@JoinColumn(name="IDMATERIAL", referencedColumnName="IDMATERIAL")
		})
	private MedioDigital medioDigital;

	public Dvd() {
	}

	public DvdPK getId() {
		return this.id;
	}

	public void setId(DvdPK id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoriadvd getCategoriadvd() {
		return this.categoriadvd;
	}

	public void setCategoriadvd(Categoriadvd categoriadvd) {
		this.categoriadvd = categoriadvd;
	}

	public MedioDigital getMedioDigital() {
		return this.medioDigital;
	}

	public void setMedioDigital(MedioDigital medioDigital) {
		this.medioDigital = medioDigital;
	}

}