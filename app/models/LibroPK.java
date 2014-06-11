package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LIBRO database table.
 * 
 */
@Embeddable
public class LibroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmaterial;

	private long isbn;

	public LibroPK() {
	}
	public long getIdmaterial() {
		return this.idmaterial;
	}
	public void setIdmaterial(long idmaterial) {
		this.idmaterial = idmaterial;
	}
	public long getIsbn() {
		return this.isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LibroPK)) {
			return false;
		}
		LibroPK castOther = (LibroPK)other;
		return 
			(this.idmaterial == castOther.idmaterial)
			&& (this.isbn == castOther.isbn);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmaterial ^ (this.idmaterial >>> 32)));
		hash = hash * prime + ((int) (this.isbn ^ (this.isbn >>> 32)));
		
		return hash;
	}
}