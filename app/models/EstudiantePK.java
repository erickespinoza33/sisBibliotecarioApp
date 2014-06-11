package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ESTUDIANTE database table.
 * 
 */
@Embeddable
public class EstudiantePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private long idUsuario;

	@Column(insertable=false, updatable=false)
	private long carnet;

	private long idestudiante;

	public EstudiantePK() {
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
	public long getIdestudiante() {
		return this.idestudiante;
	}
	public void setIdestudiante(long idestudiante) {
		this.idestudiante = idestudiante;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EstudiantePK)) {
			return false;
		}
		EstudiantePK castOther = (EstudiantePK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.carnet == castOther.carnet)
			&& (this.idestudiante == castOther.idestudiante);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + ((int) (this.carnet ^ (this.carnet >>> 32)));
		hash = hash * prime + ((int) (this.idestudiante ^ (this.idestudiante >>> 32)));
		
		return hash;
	}
}