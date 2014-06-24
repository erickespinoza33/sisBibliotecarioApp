package controllers;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import models.Categoriamaterial;
import models.Cd;
import models.Material;
import models.Tipoobrareferencia;
import models.ObraReferencia;
import models.TrabajoGraduacion;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;

import java.text.*;

public class ObrasReferencia extends Controller {
	
	public static void listarOR(){
		List<ObraReferencia> listOR = ObraReferencia.findAll();
		render(listOR);
	}
	
	public static void nuevaOR(){	
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		List<Tipoobrareferencia> tiposor = Tipoobrareferencia.findAll();
		render(categorias, tiposor);
	}
	
	public static void guardarOR(String orIdM, int orIdObraRef, String orCategM, String orUbicaM, int orExistM, String orDescM, int orTipoR, String orTitulo){
		if(orIdM == null ){
			Logger.log4j.info("New " + orIdM);
			Connection conn = play.db.DB.getConnection();
			try {				
				CallableStatement prepareCall = conn.prepareCall("call INSERTAR_OBRA_REFERENCIA("+orCategM+", '"+orUbicaM+"',"+orExistM+", '"+orDescM+"', "+orTipoR+", '"+orTitulo+"')");
				Logger.log4j.info(prepareCall.execute());					
				}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}				
		}
		
		else{
			Logger.log4j.info("Update " + orIdM);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call MODIFICAR_OBRAREF("+Integer.parseInt(orIdM)+", "+orCategM+", '"+orUbicaM+"', "+orExistM+", '"+orDescM+"',"+orIdObraRef+", "+orTipoR+", '"+orTitulo+"')");
				Logger.log4j.info(prepareCall.execute());
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}			
		}
		
		redirect("/material/or/listar");	

	}
	
	public static void mostrarOR(String id){
		ObraReferencia or = ObraReferencia.find("IDOBRAREF", Long.parseLong(id)).first();		
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		List<Tipoobrareferencia> tiposor = Tipoobrareferencia.findAll();		
		Logger.log4j.info(or.getTitulo());
		render(or, categorias, tiposor);	
	}
	
	public static void eliminarOR(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		ObraReferencia or = ObraReferencia.find("IDOBRAREF", Long.parseLong(id)).first();		
		Logger.log4j.info("Eliminar " + or.getIdobraref());
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call ELIMINAR_OBRAREF("+or.getMaterial().getIdmaterial()+", "+or.getIdobraref()+")");
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
				+ "success: Obra de Referencia eliminada .\""
				+ ", \"url\":\"/material/or/listar\" }");
	}
	
	public static void agregarAutorOR(String id)
	{
		ObraReferencia or = ObraReferencia.find("IDOBRAREF", Long.parseLong(id)).first();		
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();				
		Logger.log4j.info(or.getTitulo());
		render(or, categorias);	
		
	}
	
	public static void guardarAutor(String orIdM, int orIdTg, String nomAutorOR, String apeAutorOR, String direcAutorOR, String telAutorOR){
		Logger.log4j.info("Update " + orIdM);
		Connection conn = play.db.DB.getConnection();
		try {				
			CallableStatement prepareCall = conn.prepareCall("call INSERTAR_AUTOR_OBRAREF("+Integer.parseInt(orIdM)+", "+orIdTg+", '"+nomAutorOR+"', '"+apeAutorOR+"', '"+telAutorOR+"', '"+direcAutorOR+"')");
			Logger.log4j.info(prepareCall.execute());			
			}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
				
		redirect("/material/or/listar");				
	}
	
	public static void listarAutor(String id){		
		ObraReferencia listOR= ObraReferencia.findById(Long.parseLong(id));
		List lista = listOR.getAutors();
		render(lista);
	}

}
