package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the HEMEROGRAFIA database table.
 * 
 */
@Embeddable
public class HemerografiaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	private long codigo;

	public HemerografiaPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HemerografiaPK)) {
			return false;
		}
		HemerografiaPK castOther = (HemerografiaPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.codigo == castOther.codigo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.codigo ^ (this.codigo >>> 32)));
		
		return hash;
	}
}