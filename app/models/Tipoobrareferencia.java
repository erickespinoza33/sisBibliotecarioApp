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
 * The persistent class for the TIPOOBRAREFERENCIA database table.
 * 
 */
@Entity
@Table(name="TIPOOBRAREFERENCIA")
public class Tipoobrareferencia extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDTIPOOBRAREF")
	private long idtipoobraref;

	@Column(name="TIPOREF")
	private String tiporef;

	//bi-directional many-to-one association to ObraReferencia
	@OneToMany(mappedBy="tipoobrareferencia")
	private List<ObraReferencia> obraReferencias;

	public Tipoobrareferencia() {
	}

	public long getIdtipoobraref() {
		return this.idtipoobraref;
	}

	public void setIdtipoobraref(long idtipoobraref) {
		this.idtipoobraref = idtipoobraref;
	}

	public String getTiporef() {
		return this.tiporef;
	}

	public void setTiporef(String tiporef) {
		this.tiporef = tiporef;
	}

	public List<ObraReferencia> getObraReferencias() {
		return this.obraReferencias;
	}

	public void setObraReferencias(List<ObraReferencia> obraReferencias) {
		this.obraReferencias = obraReferencias;
	}

	public ObraReferencia addObraReferencia(ObraReferencia obraReferencia) {
		getObraReferencias().add(obraReferencia);
		obraReferencia.setTipoobrareferencia(this);

		return obraReferencia;
	}

	public ObraReferencia removeObraReferencia(ObraReferencia obraReferencia) {
		getObraReferencias().remove(obraReferencia);
		obraReferencia.setTipoobrareferencia(null);

		return obraReferencia;
	}

}