package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Artista;
import models.Categoriadvd;
import models.Categoriamaterial;
import models.Cd;
import models.Dvd;
import models.Material;
import models.MedioDigital;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;

public class Dvds extends Controller {
	
	public static void nuevoDVD(){
		List<Categoriadvd> categoriasDvd = Categoriadvd.findAll();
		List<Categoriamaterial> categoriasMat = Categoriamaterial.findAll();
		render(categoriasDvd, categoriasMat);
	}

	public static void guardarDVD(String dvdTitulo, int dvdCatdvd, String dvdDescMd, String dvdDescM, int dvdExistM, String dvdUbicaM, String dvdCategM, String dvdIdM, int dvdId, int dvdIdDvd){
		if(dvdIdM == null ){
			Logger.log4j.info("New " + dvdIdM);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call INSERTAR_DVD("+dvdCategM+", '"+dvdUbicaM+"', "+dvdExistM+", '"+dvdDescM+"', '"+dvdDescMd+"',"+dvdCatdvd+", '"+dvdTitulo+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Logger.log4j.info("Update " + dvdIdM);
			Connection conn = play.db.DB.getConnection();
			try {

				CallableStatement prepareCall = conn.prepareCall("call MODIFICAR_DVD("+Integer.parseInt(dvdIdM)+", "+dvdCategM+", '"+dvdUbicaM+"', "+dvdExistM+", '"+dvdDescM+"',"+dvdId+" , '"+dvdDescMd+"', "+dvdIdDvd+", "+dvdCatdvd+", '"+dvdTitulo+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		redirect("/material/dvd/listar");

	}
	
	public static void mostrarDVD(String id){
		Dvd DVD = Dvd.find("ID", Long.parseLong(id)).first();
		List<Categoriadvd> categoriasDvd = Categoriadvd.findAll();
		List<Categoriamaterial> categoriasMat = Categoriamaterial.findAll();
		Logger.log4j.info(DVD.getTitulo());
		render(DVD, categoriasDvd, categoriasMat);	
	}
	
	
	public static void eliminarDVD(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Dvd DVD = Dvd.find("ID", Long.parseLong(id)).first();
		
		Logger.log4j.info("Eliminar " + DVD.getId());
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call ELIMINAR_DVD("+DVD.getMedioDigital().getMaterial().getIdmaterial()+", "+ DVD.getId()+", "+DVD.getIddvd()+")");
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
				+ "success: DVD Eliminado .\""
				+ ", \"url\":\"/material/dvd/listar\" }");
	}
	
	public static void listarDVD(){
		List<Dvd> listDvds = Dvd.findAll();
		render(listDvds);
	}
}
