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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * The persistent class for the PRESTAMISTA database table.
 * 
 */
@Entity
@Table(name="PRESTAMISTA")
public class Prestamista extends GenericModel {

	@Id
	@Column(name="CARNET")
	private long carnet;
	
	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Column(name="CARNETRECIBIDO")
	private BigDecimal carnetrecibido;

	@Column(name="CORREO")
	private String correo;

	@Column(name="DIRECCIONPRESTAMISTA")
	private String direccionprestamista;

	@Column(name="DOCUMENTO")
	private String documento;

	@Column(name="FECHAEXPIRACION")
	private Date fechaexpiracion;

	@Column(name="FECHASUSCRIPCION")
	private Date fechasuscripcion;

	@Column(name="TELFIJO")
	private String telfijo;

	@Column(name="TELMOVIL")
	private String telmovil;

	//bi-directional many-to-one association to Bibliotecologo
	@ManyToOne
	private Bibliotecologo bibliotecologo;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="prestamista")
	private List<Estudiante> estudiantes;
	//bi-directional many-to-one association to Externo
	@OneToMany(mappedBy="prestamista")
	private List<Externo> externos;
	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="prestamista")
	private List<Prestamo> prestamos;
	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="prestamista")
	private List<Profesor> profesors;

	public Prestamista() {
	}

	public BigDecimal getCarnetrecibido() {
		return this.carnetrecibido;
	}

	public void setCarnetrecibido(BigDecimal carnetrecibido) {
		this.carnetrecibido = carnetrecibido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccionprestamista() {
		return this.direccionprestamista;
	}

	public void setDireccionprestamista(String direccionprestamista) {
		this.direccionprestamista = direccionprestamista;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaexpiracion() {
		return this.fechaexpiracion;
	}

	public void setFechaexpiracion(Date fechaexpiracion) {
		this.fechaexpiracion = fechaexpiracion;
	}

	public Date getFechasuscripcion() {
		return this.fechasuscripcion;
	}

	public void setFechasuscripcion(Date fechasuscripcion) {
		this.fechasuscripcion = fechasuscripcion;
	}

	public String getTelfijo() {
		return this.telfijo;
	}

	public void setTelfijo(String telfijo) {
		this.telfijo = telfijo;
	}

	public String getTelmovil() {
		return this.telmovil;
	}

	public void setTelmovil(String telmovil) {
		this.telmovil = telmovil;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setPrestamista(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setPrestamista(null);

		return estudiante;
	}

	public List<Externo> getExternos() {
		return this.externos;
	}

	public void setExternos(List<Externo> externos) {
		this.externos = externos;
	}

	public Externo addExterno(Externo externo) {
		getExternos().add(externo);
		externo.setPrestamista(this);

		return externo;
	}

	public Externo removeExterno(Externo externo) {
		getExternos().remove(externo);
		externo.setPrestamista(null);

		return externo;
	}

	public Bibliotecologo getBibliotecologo() {
		return this.bibliotecologo;
	}

	public void setBibliotecologo(Bibliotecologo bibliotecologo) {
		this.bibliotecologo = bibliotecologo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo addPrestamo(Prestamo prestamo) {
		getPrestamos().add(prestamo);
		prestamo.setPrestamista(this);

		return prestamo;
	}

	public Prestamo removePrestamo(Prestamo prestamo) {
		getPrestamos().remove(prestamo);
		prestamo.setPrestamista(null);

		return prestamo;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setPrestamista(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setPrestamista(null);

		return profesor;
	}

	@Override
	public String toString() {
		return "Prestamista [carnet=" + carnet + ", idUsuario=" + idUsuario
				+ ", carnetrecibido=" + carnetrecibido + ", correo=" + correo
				+ ", direccionprestamista=" + direccionprestamista
				+ ", documento=" + documento + ", fechaexpiracion="
				+ fechaexpiracion + ", fechasuscripcion=" + fechasuscripcion
				+ ", telfijo=" + telfijo + ", telmovil=" + telmovil
				+ ", bibliotecologo=" + bibliotecologo + ", usuario=" + usuario
				+ ", estudiantes=" + estudiantes + ", externos=" + externos
				+ ", prestamos=" + prestamos + ", profesors=" + profesors + "]";
	}

}