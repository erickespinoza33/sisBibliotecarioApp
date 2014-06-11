package models;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;
import play.data.validation.Required;
import play.data.validation.MaxSize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the BIBLIOTECOLOGO database table.
 * 
 */
@Entity
@Table(name="BIBLIOTECOLOGO")
public class Bibliotecologo extends GenericModel {

	@Id
	@Column(name="IDBIBLIO")
	private long idbiblio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Prestamista
	@OneToMany(mappedBy="bibliotecologo")
	private List<Prestamista> prestamistas;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="bibliotecologo")
	private List<Prestamo> prestamos;

	public Bibliotecologo() {
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Prestamista> getPrestamistas() {
		return this.prestamistas;
	}

	public void setPrestamistas(List<Prestamista> prestamistas) {
		this.prestamistas = prestamistas;
	}

	public Prestamista addPrestamista(Prestamista prestamista) {
		getPrestamistas().add(prestamista);
		prestamista.setBibliotecologo(this);

		return prestamista;
	}

	public Prestamista removePrestamista(Prestamista prestamista) {
		getPrestamistas().remove(prestamista);
		prestamista.setBibliotecologo(null);

		return prestamista;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo addPrestamo(Prestamo prestamo) {
		getPrestamos().add(prestamo);
		prestamo.setBibliotecologo(this);

		return prestamo;
	}

	public Prestamo removePrestamo(Prestamo prestamo) {
		getPrestamos().remove(prestamo);
		prestamo.setBibliotecologo(null);

		return prestamo;
	}

	@Override
	public String toString() {
		return "Bibliotecologo [idbiblio=" + idbiblio + ", usuario=" + usuario
				+ ", prestamistas=" + prestamistas + ", prestamos=" + prestamos
				+ "]";
	}

}