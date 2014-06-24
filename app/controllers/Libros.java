package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;

import models.Autor;
import models.Categoriamaterial;
import models.Editorial;
import models.Idioma;
import models.Libro;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;

public class Libros extends Controller {
	
	public static void nuevoLibro(){
		List<Idioma> idiomas = Idioma.findAll();
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		List<Editorial> editoriales = Editorial.findAll();
		render(idiomas, categorias, editoriales);
	}
	
	public static void mostrarautorLibro(String id){
		Autor autor = Autor.find("idautor", Long.parseLong(id)).first();
		render(autor);
	}
	
	public static void guardarLibro(int libCategM, String libUbicaM, int libExistM, String libDescM, int libISBN, int libEditorial, String libTitulo, int libEdicion, int libVolumen, int libCosto, int Donado, int idioma, String libIdM, String logo){
		logo = null;
		if(libIdM == null ){
			Logger.log4j.info("New " + libIdM);
			Connection conn = play.db.DB.getConnection();
			
			try {
				CallableStatement prepareCall = conn.prepareCall("call INSERTARLIBRO("+libCategM+", '"+libUbicaM+"', "+libExistM+", '"+libDescM+"', "+libISBN+","+libEditorial+", '"+libTitulo+"', "+libEdicion+","+libVolumen+","+libCosto+","+Donado+",'"+logo+"',"+idioma+")");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Logger.log4j.info("Update " + libIdM);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call MODIFICARLIBRO("+libIdM+","+libCategM+", '"+libUbicaM+"', "+libExistM+", '"+libDescM+"', "+libISBN+","+libEditorial+", '"+libTitulo+"', "+libEdicion+","+libVolumen+","+libCosto+","+Donado+",'"+logo+"',"+idioma+")");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		redirect("/material/libro/listar");
		
	}
	
	public static void guardarautorLibro(String autorIdM, int autorISBN,String idAutor,String nomAutor, String apeAutor,String telAutor, String dirAutor){
		
		if(idAutor == null ){
			Logger.log4j.info("New " + idAutor);
			Connection conn = play.db.DB.getConnection();
			
			try {
				CallableStatement prepareCall = conn.prepareCall("call INSERTAR_AUTOR_LIBRO("+autorIdM+","+ autorISBN+",'"+nomAutor+"','"+apeAutor+"','"+telAutor+"','"+dirAutor+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Logger.log4j.info("Update " + idAutor);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call MODIFICAR_AUTOR_LIBRO("+idAutor+",'"+nomAutor+"','"+apeAutor+"','"+telAutor+"','"+dirAutor+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		redirect("/material/libro/listar");
		
	}
	
	public static void mostrarLibro(String id){
		Libro libro = Libro.find("ISBN", Long.parseLong(id)).first();
		List<Idioma> idiomas = Idioma.findAll();
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		List<Editorial> editoriales = Editorial.findAll();
		Logger.log4j.info(libro.getTitulo());
		render(libro, idiomas, categorias, editoriales);	
	}
	
	public static void nuevoautorLibro(String id){
		Libro libro = Libro.find("ISBN", Long.parseLong(id)).first();
		Logger.log4j.info(libro.getTitulo());
		render(libro);	
	}
	
	
	public static void eliminarLibro(String id){
		Logger.log4j.info("ISBN a Eliminar "+id);
		Libro libro = Libro.find("ISBN", Long.parseLong(id)).first();
		
		Logger.log4j.info("Eliminar " + libro.getISBN());
		Connection conn = play.db.DB.getConnection();
		try {
			List<Idioma> idiomas = libro.getIdiomas();			
			Logger.log4j.info("Id idioma");
			CallableStatement prepareCall = conn.prepareCall("call ELIMINARLIBRO("+libro.getMaterial().getIdmaterial()+", "+libro.getISBN()+","+ idiomas.get(0).getIdidiomas()+")");
			Logger.log4j.info(prepareCall.execute());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		renderJSON("{\"success\":"
				+ true
				+ ", \"code\":"
				+ 500
				+ " ,\"message\":\" "
				+ "success: Libro Eliminado .\""
				+ ", \"url\":\"/material/libro/listar\" }");
	}
	
	public static void listarLibros(){
		List<Libro> listLibros = Libro.findAll();
		Logger.log4j.info("--------------:" + listLibros.size());
		render(listLibros);
	}
	
	public static void listarautorLibros(String id){
		Libro libro = Libro.find("ISBN", Long.parseLong(id)).first();
		List<Autor> listAutor = libro.getAutors();
		render(libro,listAutor);
	}

}
