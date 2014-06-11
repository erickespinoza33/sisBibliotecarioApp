package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PRESTAMISTA database table.
 * 
 */
@Embeddable
public class PrestamistaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private long idUsuario;

	private long carnet;

	public PrestamistaPK() {
	}
	public long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getCarnet() {
		return this.carnet;
	}
	public void setCarnet(long carnet) {
		this.carnet = carnet;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrestamistaPK)) {
			return false;
		}
		PrestamistaPK castOther = (PrestamistaPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.carnet == castOther.carnet);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + ((int) (this.carnet ^ (this.carnet >>> 32)));
		
		return hash;
	}
}