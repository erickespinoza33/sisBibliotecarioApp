package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DVD database table.
 * 
 */
@Embeddable
public class DvdPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	@Column(insertable=false, updatable=false)
	private long id;

	private long iddvd;

	public DvdPK() {
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
	public long getIddvd() {
		return this.iddvd;
	}
	public void setIddvd(long iddvd) {
		this.iddvd = iddvd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DvdPK)) {
			return false;
		}
		DvdPK castOther = (DvdPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.id == castOther.id)
			&& (this.iddvd == castOther.iddvd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.id ^ (this.id >>> 32)));
		hash = hash * prime + ((int) (this.iddvd ^ (this.iddvd >>> 32)));
		
		return hash;
	}
}