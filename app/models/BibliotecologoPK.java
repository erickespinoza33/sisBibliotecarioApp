package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BIBLIOTECOLOGO database table.
 * 
 */
public class BibliotecologoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private long idUsuario;

	private long idbiblio;

	public BibliotecologoPK() {
	}
	public long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdbiblio() {
		return this.idbiblio;
	}
	public void setIdbiblio(long idbiblio) {
		this.idbiblio = idbiblio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BibliotecologoPK)) {
			return false;
		}
		BibliotecologoPK castOther = (BibliotecologoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idbiblio == castOther.idbiblio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + ((int) (this.idbiblio ^ (this.idbiblio >>> 32)));
		
		return hash;
	}
}