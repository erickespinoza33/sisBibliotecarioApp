package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MAPA database table.
 * 
 */
@Embeddable
public class MapaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	private long idmapa;

	public MapaPK() {
	}
	public long getIdmaterial() {
		return this.idmaterial;
	}
	public void setIdmaterial(long idmaterial) {
		this.idmaterial = idmaterial;
	}
	public long getIdmapa() {
		return this.idmapa;
	}
	public void setIdmapa(long idmapa) {
		this.idmapa = idmapa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MapaPK)) {
			return false;
		}
		MapaPK castOther = (MapaPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.idmapa == castOther.idmapa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.idmapa ^ (this.idmapa >>> 32)));
		
		return hash;
	}
}