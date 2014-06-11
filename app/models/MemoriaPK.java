package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MEMORIA database table.
 * 
 */
@Embeddable
public class MemoriaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	private long idmemoria;

	public MemoriaPK() {
	}
	public long getIdmaterial() {
		return this.idmaterial;
	}
	public void setIdmaterial(long idmaterial) {
		this.idmaterial = idmaterial;
	}
	public long getIdmemoria() {
		return this.idmemoria;
	}
	public void setIdmemoria(long idmemoria) {
		this.idmemoria = idmemoria;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MemoriaPK)) {
			return false;
		}
		MemoriaPK castOther = (MemoriaPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.idmemoria == castOther.idmemoria);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.idmemoria ^ (this.idmemoria >>> 32)));
		
		return hash;
	}
}