package models;

public class ReportLibroExistencia {

	String id;
	String titulolibro;
	String edicion;
	String nombreeditorial;
	String totallibros;
	String ejemplares;
	String ubicacion;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulolibro() {
		return titulolibro;
	}
	public void setTitulolibro(String titulolibro) {
		this.titulolibro = titulolibro;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	public String getNombreeditorial() {
		return nombreeditorial;
	}
	public void setNombreeditorial(String nombreeditorial) {
		this.nombreeditorial = nombreeditorial;
	}
	public String getTotallibros() {
		return totallibros;
	}
	public void setTotallibros(String totallibros) {
		this.totallibros = totallibros;
	}
	public String getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(String ejemplares) {
		this.ejemplares = ejemplares;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public ReportLibroExistencia(String id, String titulolibro, String edicion,
			String nombreeditorial, String totallibros, String ejemplares,
			String ubicacion) {
		super();
		this.id = id;
		this.titulolibro = titulolibro;
		this.edicion = edicion;
		this.nombreeditorial = nombreeditorial;
		this.totallibros = totallibros;
		this.ejemplares = ejemplares;
		this.ubicacion = ubicacion;
	}
	public ReportLibroExistencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReportLibroExistencia [id=" + id + ", titulolibro="
				+ titulolibro + ", edicion=" + edicion + ", nombreeditorial="
				+ nombreeditorial + ", totallibros=" + totallibros
				+ ", ejemplares=" + ejemplares + ", ubicacion=" + ubicacion
				+ "]";
	}
	
}
