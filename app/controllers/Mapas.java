package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import models.Categoriamaterial;
import models.Material;
import models.Mapa;
import models.Categoriamapa;
import models.ObraReferencia;
import models.Tipoobrareferencia;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;

import java.text.*;

public class Mapas extends Controller {
	
	public static void listarMapa(){
		List<Mapa> listM = Mapa.findAll();
		render(listM);
	}
	
	public static void nuevoMapa(){	
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		List<Categoriamapa> catmapa = Categoriamapa.findAll();
		render(categorias, catmapa);
	}
	
	public static void guardarMapa(String mapaIdM, int mIdMapa, String mapaCategM, String mapaUbicaM, int mapaExistM, String mapaDescM, int catMapa, String mapaTitulo, String mapaFuente, String mapaEscala, String mapaLugar){
		if(mapaIdM == null ){
			Logger.log4j.info("New " + mapaIdM);
			Connection conn = play.db.DB.getConnection();
			try {				
				CallableStatement prepareCall = conn.prepareCall("call insertar_mapa("+mapaCategM+", '"+mapaUbicaM+"',"+mapaExistM+", '"+mapaDescM+"', "+catMapa+", '"+mapaTitulo+"', '"+mapaFuente+"', '"+mapaEscala+"', '"+mapaLugar+"')");
				Logger.log4j.info(prepareCall.execute());					
				}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}				
		}
		
		else{
			Logger.log4j.info("Update " + mapaIdM);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call modificar_mapa("+Integer.parseInt(mapaIdM)+", "+mapaCategM+", '"+mapaUbicaM+"', "+mapaExistM+", '"+mapaDescM+"',"+mIdMapa+", "+catMapa+", '"+mapaTitulo+"', '"+mapaFuente+"', '"+mapaEscala+"', '"+mapaLugar+"')");
				Logger.log4j.info(prepareCall.execute());
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}	
			
			redirect("/material/mapa/listar");
		}
	}
	
	public static void mostrarMapa(String id){
		Mapa mapa = Mapa.find("IDMAPA", Long.parseLong(id)).first();		
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		List<Categoriamapa> catmapa = Categoriamapa.findAll();			
		render(mapa, categorias, catmapa);	
	}
	
	public static void eliminarMapa(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Mapa mapa = Mapa.find("IDMAPA", Long.parseLong(id)).first();			
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call eliminar_mapa("+mapa.getMaterial().getIdmaterial()+", "+mapa.getIdmapa()+")");
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
				+ "success: Mapa eliminado .\""
				+ ", \"url\":\"/material/mapa/listar\" }");
	}
	
	public static void agregarAutorMapa(String id)
	{
		Mapa mapa = Mapa.find("IDMAPA", Long.parseLong(id)).first();			
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();		
		render(mapa, categorias);	
		
	}
	
	public static void guardarAutor(String mapaIdM, int mIdMapa, String nomAutorM, String apeAutorM, String direcAutorM, String telAutorM){
		Logger.log4j.info("Update " + mapaIdM);
		Connection conn = play.db.DB.getConnection();
		try {				
			CallableStatement prepareCall = conn.prepareCall("call insertar_autor_mapa("+Integer.parseInt(mapaIdM)+", "+mIdMapa+", '"+nomAutorM+"', '"+apeAutorM+"', '"+telAutorM+"', '"+direcAutorM+"')");
			Logger.log4j.info(prepareCall.execute());			
			}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
				
		redirect("/material/mapa/listar");				
	}
	
	public static void listarAutor(String id){		
		Mapa listM= Mapa.findById(Long.parseLong(id));
		List lista = listM.getAutors();
		render(lista);
	}
	

}
