package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TRABAJO_GRADUACION database table.
 * 
 */
@Entity
@Table(name="TRABAJO_GRADUACION")
@NamedQuery(name="TrabajoGraduacion.findAll", query="SELECT t FROM TrabajoGraduacion t")
public class TrabajoGraduacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TrabajoGraduacionPK id;

	private String asesor;

	private BigDecimal cd;

	@Temporal(TemporalType.DATE)
	private Date fechaarchivado;

	private String tema;

	//bi-directional many-to-many association to Autor
	@ManyToMany
	@JoinTable(
		name="TRABAJOSG_AUTORES"
		, joinColumns={
			@JoinColumn(name="IDMATERIAL", referencedColumnName="IDMATERIAL"),
			@JoinColumn(name="IDTG", referencedColumnName="IDTG")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDAUTOR")
			}
		)
	private List<Autor> autors;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="IDMATERIAL")
	private Material material;

	public TrabajoGraduacion() {
	}

	public TrabajoGraduacionPK getId() {
		return this.id;
	}

	public void setId(TrabajoGraduacionPK id) {
		this.id = id;
	}

	public String getAsesor() {
		return this.asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public BigDecimal getCd() {
		return this.cd;
	}

	public void setCd(BigDecimal cd) {
		this.cd = cd;
	}

	public Date getFechaarchivado() {
		return this.fechaarchivado;
	}

	public void setFechaarchivado(Date fechaarchivado) {
		this.fechaarchivado = fechaarchivado;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<Autor> getAutors() {
		return this.autors;
	}

	public void setAutors(List<Autor> autors) {
		this.autors = autors;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}