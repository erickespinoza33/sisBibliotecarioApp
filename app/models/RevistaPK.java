package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REVISTA database table.
 * 
 */
@Embeddable
public class RevistaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	@Column(insertable=false, updatable=false)
	private long codigo;

	private long idrevista;

	public RevistaPK() {
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
	public long getIdrevista() {
		return this.idrevista;
	}
	public void setIdrevista(long idrevista) {
		this.idrevista = idrevista;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RevistaPK)) {
			return false;
		}
		RevistaPK castOther = (RevistaPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.codigo == castOther.codigo)
			&& (this.idrevista == castOther.idrevista);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.codigo ^ (this.codigo >>> 32)));
		hash = hash * prime + ((int) (this.idrevista ^ (this.idrevista >>> 32)));
		
		return hash;
	}
}