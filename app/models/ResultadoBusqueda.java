package models;

public class ResultadoBusqueda {
	
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ResultadoBusqueda [id=" + id + ", name=" + name + "]";
	}
	public ResultadoBusqueda(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
