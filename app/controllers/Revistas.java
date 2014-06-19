package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;

import models.Categoriamaterial;
import models.Editorial;
import models.Material;
import models.MedioDigital;
import models.Revista;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;

public class Revistas extends Controller {
	
	public static void nuevoRevista(){
		List<Editorial> editoriales = Editorial.findAll();
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		render(editoriales, categorias);
	}

	public static void guardarRevista(int revEdicion,String revTitulo,String revDescH, String revLugarEd, double revPrecio, String revFechaPub, String revEditorial, String revDescM, int revExistM, String revUbicaM, String revCategM, int revId, int revIdCodigo, String revIdM){
		if(revIdM == null ){
			Logger.log4j.info("New " + revIdM);
			Connection conn = play.db.DB.getConnection();
			try { 	
				CallableStatement prepareCall = conn.prepareCall("call INSERTARREVISTA("+revCategM+", '"+revUbicaM+"', "+revExistM+", '"+revDescM+"', "+revEditorial+",'"+revFechaPub+"', "+revPrecio+", '"+revLugarEd+"','"+revDescH+"','"+revTitulo+"','"+revEdicion+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Logger.log4j.info("Update " + revIdM);
			Connection conn = play.db.DB.getConnection();
			try {
				
				CallableStatement prepareCall = conn.prepareCall("call modificarRevista("+Integer.parseInt(revIdM)+","+revCategM+",'"+revUbicaM+"', "+revExistM+", '"+revDescM+"',"+revIdCodigo+", "+revEditorial+",'"+revFechaPub+"', "+revPrecio+", '"+revLugarEd+"','"+revDescH+"',"+revId+",'"+revTitulo+"','"+revEdicion+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		redirect("/material/revista/listar");

	}
	
	public static void mostrarRevista(String id){
		Revista Rev = Revista.find("IDREVISTA", Long.parseLong(id)).first();
		List<Editorial> editoriales = Editorial.findAll();
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		Logger.log4j.info(Rev.getTitulo());
		render(Rev, editoriales, categorias);	
	}
	
	
	public static void eliminarRevista(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Revista Rev = Revista.find("IDREVISTA", Long.parseLong(id)).first();
		
		Logger.log4j.info("Eliminar " + Rev.getIdRevista());
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call eliminarRevista("+Rev.getHemerografia().getMaterial().getIdmaterial()+","+Rev.getHemerografia().getCodigo()+", "+Rev.getIdRevista()+")");
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
				+ "success: Revista Eliminada .\""
				+ ", \"url\":\"/material/revista/listar\" }");
	}
	
	public static void listarRevista(){
		List<Revista> listRev = Revista.findAll();
		render(listRev);
	}
	
	
}
