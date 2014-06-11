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
 * The persistent class for the PERIODICO database table.
 * 
 */
@Entity
@Table(name="PERIODICO")
public class Periodico extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDPERIODICO")
	private long idperiodico;
	
	@Column(name="EMPRESA")
	private String empresa;

	@Column(name="TITULAR")
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