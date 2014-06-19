package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Artista;
import models.Categoriamaterial;
import models.Cd;
import models.Libro;
import play.Logger;
import play.mvc.Controller;

public class Libros extends Controller {
	
	public static void nuevoLibro(){
		List<Artista> artistas = Artista.findAll();
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		render(artistas, categorias);
	}

	public static void guardarLibro(int cdAnio, String cdAlbum, int cdArtista, String cdDescMd, String cdDescM, int cdExistM, String cdUbicaM, String cdCategM, String cdIdM, int cdId, int cdIdCd){
		if(cdIdM == null ){
			Logger.log4j.info("New " + cdIdM);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call INSERTAR_cd("+cdCategM+", '"+cdUbicaM+"', "+cdExistM+", '"+cdDescM+"', '"+cdDescMd+"',"+cdArtista+", '"+cdAlbum+"', "+cdAnio+")");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Logger.log4j.info("Update " + cdIdM);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call MODIFICAR_CD("+Integer.parseInt(cdIdM)+", "+cdCategM+", '"+cdUbicaM+"', "+cdExistM+", '"+cdDescM+"',"+cdId+" , '"+cdDescMd+"', "+cdIdCd+", "+cdArtista+", '"+cdAlbum+"', "+cdAnio+")");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		redirect("/material/cd/listar");

	}
	
	public static void mostrarLibro(String id){
		Cd cd = Cd.find("ID", Long.parseLong(id)).first();
		List<Artista> artistas = Artista.findAll();
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		Logger.log4j.info(cd.getAlbum());
		render(cd, artistas, categorias);	
	}
	
	
	public static void eliminarLibro(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Cd cd = Cd.find("ID", Long.parseLong(id)).first();
		
		Logger.log4j.info("Eliminar " + cd.getId());
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call ELIMINAR_CD("+cd.getMedioDigital().getMaterial().getIdmaterial()+", "+cd.getId()+",  "+cd.getIdcd()+")");
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
				+ ", \"url\":\"/material/cd/listar\" }");
	}
	
	public static void listarLibros(){
		List<Libro> listLibros = Libro.findAll();
		Logger.log4j.info("--------------:" + listLibros.size());
		render(listLibros);
	}

}
