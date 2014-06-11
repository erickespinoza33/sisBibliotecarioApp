package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MEDIO_DIGITAL database table.
 * 
 */
@Embeddable
public class MedioDigitalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	private long id;

	public MedioDigitalPK() {
	}
	public long getIdmaterial() {
		return this.idmaterial;
	}
	public void setIdmaterial(long idmaterial) {
		this.idmaterial = idmaterial;
	}
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MedioDigitalPK)) {
			return false;
		}
		MedioDigitalPK castOther = (MedioDigitalPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.id ^ (this.id >>> 32)));
		
		return hash;
	}
}