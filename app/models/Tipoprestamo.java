package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TIPOPRESTAMO database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoprestamo.findAll", query="SELECT t FROM Tipoprestamo t")
public class Tipoprestamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idtipoprestamo;

	private BigDecimal activo;

	private String tipo;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="tipoprestamo")
	private List<Prestamo> prestamos;

	public Tipoprestamo() {
	}

	public long getIdtipoprestamo() {
		return this.idtipoprestamo;
	}

	public void setIdtipoprestamo(long idtipoprestamo) {
		this.idtipoprestamo = idtipoprestamo;
	}

	public BigDecimal getActivo() {
		return this.activo;
	}

	public void setActivo(BigDecimal activo) {
		this.activo = activo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo addPrestamo(Prestamo prestamo) {
		getPrestamos().add(prestamo);
		prestamo.setTipoprestamo(this);

		return prestamo;
	}

	public Prestamo removePrestamo(Prestamo prestamo) {
		getPrestamos().remove(prestamo);
		prestamo.setTipoprestamo(null);

		return prestamo;
	}

}