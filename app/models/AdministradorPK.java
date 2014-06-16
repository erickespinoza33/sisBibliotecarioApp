package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ADMINISTRADOR database table.
 * 
 */

public class AdministradorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private long idUsuario;

	private long idadmin;

	public AdministradorPK() {
	}
	public long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdadmin() {
		return this.idadmin;
	}
	public void setIdadmin(long idadmin) {
		this.idadmin = idadmin;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AdministradorPK)) {
			return false;
		}
		AdministradorPK castOther = (AdministradorPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idadmin == castOther.idadmin);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + ((int) (this.idadmin ^ (this.idadmin >>> 32)));
		
		return hash;
	}
}