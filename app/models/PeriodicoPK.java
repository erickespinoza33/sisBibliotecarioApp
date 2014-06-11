package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERIODICO database table.
 * 
 */
@Embeddable
public class PeriodicoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	@Column(insertable=false, updatable=false)
	private long codigo;

	private long idperiodico;

	public PeriodicoPK() {
	}
	public long getIdmaterial() {
		return this.idmaterial;
	}
	public void setIdmaterial(long idmaterial) {
		this.idmaterial = idmaterial;
	}
	public long getCodigo() {
		return this.codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getIdperiodico() {
		return this.idperiodico;
	}
	public void setIdperiodico(long idperiodico) {
		this.idperiodico = idperiodico;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PeriodicoPK)) {
			return false;
		}
		PeriodicoPK castOther = (PeriodicoPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.codigo == castOther.codigo)
			&& (this.idperiodico == castOther.idperiodico);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.codigo ^ (this.codigo >>> 32)));
		hash = hash * prime + ((int) (this.idperiodico ^ (this.idperiodico >>> 32)));
		
		return hash;
	}
}