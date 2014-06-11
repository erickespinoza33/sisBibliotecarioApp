package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CD database table.
 * 
 */
@Embeddable
public class CdPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	@Column(insertable=false, updatable=false)
	private long id;

	private long idcd;

	public CdPK() {
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
	public long getIdcd() {
		return this.idcd;
	}
	public void setIdcd(long idcd) {
		this.idcd = idcd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CdPK)) {
			return false;
		}
		CdPK castOther = (CdPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.id == castOther.id)
			&& (this.idcd == castOther.idcd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.id ^ (this.id >>> 32)));
		hash = hash * prime + ((int) (this.idcd ^ (this.idcd >>> 32)));
		
		return hash;
	}
}