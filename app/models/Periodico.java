package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PERIODICO database table.
 * 
 */
@Entity
@NamedQuery(name="Periodico.findAll", query="SELECT p FROM Periodico p")
public class Periodico implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PeriodicoPK id;

	private String empresa;

	private String titular;

	//bi-directional many-to-one association to Hemerografia
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CODIGO", referencedColumnName="CODIGO"),
		@JoinColumn(name="IDMATERIAL", referencedColumnName="IDMATERIAL")
		})
	private Hemerografia hemerografia;

	public Periodico() {
	}

	public PeriodicoPK getId() {
		return this.id;
	}

	public void setId(PeriodicoPK id) {
		this.id = id;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Hemerografia getHemerografia() {
		return this.hemerografia;
	}

	public void setHemerografia(Hemerografia hemerografia) {
		this.hemerografia = hemerografia;
	}

}