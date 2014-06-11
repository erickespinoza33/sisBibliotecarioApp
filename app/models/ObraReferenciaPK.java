package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the OBRA_REFERENCIA database table.
 * 
 */
@Embeddable
public class ObraReferenciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	private long idobraref;

	public ObraReferenciaPK() {
	}
	public long getIdmaterial() {
		return this.idmaterial;
	}
	public void setIdmaterial(long idmaterial) {
		this.idmaterial = idmaterial;
	}
	public long getIdobraref() {
		return this.idobraref;
	}
	public void setIdobraref(long idobraref) {
		this.idobraref = idobraref;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ObraReferenciaPK)) {
			return false;
		}
		ObraReferenciaPK castOther = (ObraReferenciaPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.idobraref == castOther.idobraref);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.idobraref ^ (this.idobraref >>> 32)));
		
		return hash;
	}
}