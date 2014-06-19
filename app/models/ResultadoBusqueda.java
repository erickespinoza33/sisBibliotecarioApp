package models;

public class ResultadoBusqueda {
	
	private long id;
	private String nombres;
	private String apellidos;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Override
	public String toString() {
		return "ResultadoBusqueda [id=" + id + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + "]";
	}
	
	public ResultadoBusqueda(long id, String nombres, String apellidos) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	
	
}
