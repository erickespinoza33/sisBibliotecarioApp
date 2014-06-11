package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TRABAJO_GRADUACION database table.
 * 
 */
@Embeddable
public class TrabajoGraduacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	private long idtg;

	public TrabajoGraduacionPK() {
	}
	public long getIdmaterial() {
		return this.idmaterial;
	}
	public void setIdmaterial(long idmaterial) {
		this.idmaterial = idmaterial;
	}
	public long getIdtg() {
		return this.idtg;
	}
	public void setIdtg(long idtg) {
		this.idtg = idtg;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrabajoGraduacionPK)) {
			return false;
		}
		TrabajoGraduacionPK castOther = (TrabajoGraduacionPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.idtg == castOther.idtg);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.idtg ^ (this.idtg >>> 32)));
		
		return hash;
	}
}