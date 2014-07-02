package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import models.*;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;

public class Prestamos extends Controller {
	final static Gson gson = new Gson();
	
	
	public static void nuevoPrestamo(){
		List<Bibliotecologo> litsBiblio = Bibliotecologo.findAll();
		List<Prestamista> litsPresta = Prestamista.findAll();
		List<Categoriamaterial> listaTipoMateial = Categoriamaterial.findAll();
		List<Tipoprestamo> listaTipoPrestamo = Tipoprestamo.findAll();
		render(litsBiblio, litsPresta, listaTipoMateial, listaTipoPrestamo);
	}

	public static void guardarPrestamo(String prestamoId, String presBiblioId,String prestPrestId,String presTipoMat,String presMatIdSelect,String presTipoPres,String presEstado,String presFechaIn,String presFechaFin,String presFecahDev){
		
		Logger.log4j.info(prestPrestId);
		Bibliotecologo b = Bibliotecologo.find("IDBIBLIO", Long.parseLong(presBiblioId)).first();
		Prestamista p = Prestamista.find("CARNET", Long.parseLong(prestPrestId)).first();
		
		if(prestamoId == null ){
			Logger.log4j.info("New ----------------->");
			Connection conn = play.db.DB.getConnection();
			try { 	
				Logger.log4j.info(presFechaIn);
				CallableStatement prepareCall = conn.prepareCall("call INSERTARPRESTAMO("+p.getUsuario().getIdUsuario()+" ,"+ p.getCarnet()+" ,"+b.getUsuario().getIdUsuario()+", "+b.getIdbiblio()+", "+Long.parseLong(presMatIdSelect)+", "+Long.parseLong(presTipoPres)+" ,'"+presFechaIn+"')");
				Logger.log4j.info("call INSERTARPRESTAMO("+p.getUsuario().getIdUsuario()+" ,"+ p.getCarnet()+" ,"+b.getUsuario().getIdUsuario()+", "+b.getIdbiblio()+", "+Long.parseLong(presMatIdSelect)+", "+Long.parseLong(presTipoPres)+" ,'"+presFechaIn+"')");
				Logger.log4j.info(prepareCall.execute()); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Logger.log4j.info("Update -------------->" + prestamoId  + presFechaIn);
			Connection conn = play.db.DB.getConnection();
			try {
				
				CallableStatement prepareCall = conn.prepareCall("call MODIFICAR_PRESTAMO("+Long.parseLong(prestamoId)+" ,"+p.getUsuario().getIdUsuario()+" ,"+ p.getCarnet()+" ,"+b.getUsuario().getIdUsuario()+", "+b.getIdbiblio()+", "+Long.parseLong(presMatIdSelect)+", "+Long.parseLong(presTipoPres)+" , "+Long.parseLong(presEstado)+" ,'"+presFechaIn+"','"+presFecahDev+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		redirect("/prestamo/listar");

	}
	
	public static void mostrarPrestamo(String id){
		Prestamo prestamo = Prestamo.find("IDPRESTAMO", Long.parseLong(id)).first();
		List<Bibliotecologo> litsBiblio = Bibliotecologo.findAll();
		List<Prestamista> litsPresta = Prestamista.findAll();

		List<Categoriamaterial> listaTipoMateial = Categoriamaterial.findAll();
		List<Tipoprestamo> listaTipoPrestamo = Tipoprestamo.findAll();
		render(prestamo, litsBiblio, litsPresta, listaTipoMateial, listaTipoPrestamo);	
	}
	
	
	public static void eliminarPrestamo(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Prestamo prestamo = Prestamo.find("IDPRESTAMO", Long.parseLong(id)).first();
		
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call ");
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
				+ "success: Prestamo Eliminado .\""
				+ ", \"url\":\"/prestamo/listar\" }");
	}
	
	public static void listarPrestamo(){
		List<Prestamo> listPrestamo = Prestamo.findAll();
		Logger.log4j.info(listPrestamo.size());
		render(listPrestamo);
	}
	
	public static void buscarBibliotecologo(String q){
		Logger.log4j.info(q);
		List<Usuario> listarUser = Usuario.find("byApellidosLike", "%"+q+"%").fetch();
		List<ResultadoBusqueda> result = new ArrayList<ResultadoBusqueda>();;
		for (int i = 0; i < listarUser.size(); i++) {
			Usuario usuario = listarUser.get(i);
			Logger.log4j.info(i);
			if(usuario.getRol().getIdrol() != 2){
				Logger.log4j.info(usuario.getNombres()+" "+usuario.getIdUsuario());
				ResultadoBusqueda itemResult = new ResultadoBusqueda(usuario.getIdUsuario(), usuario.getNombres() +" "+ usuario.getApellidos());
				Logger.log4j.info(itemResult); 
				result.add(itemResult);
			}
		}
		renderJSON( gson.toJson(result));
	}
	
	public static void buscarMaterial(String id){
		Logger.log4j.info(id);
		Categoriamaterial catmat = Categoriamaterial.findById(Long.parseLong(id));
		List<ResultadoBusqueda> result = new ArrayList<ResultadoBusqueda>();;
		switch (catmat.getCategoriamat()) {
			case "Libro":
				Logger.log4j.info("Libro");
				List<Libro> libros = Libro.findAll();
				for (int i = 0; i < libros.size(); i++) {
					Libro libro = libros.get(i);
					ResultadoBusqueda itemResult = new ResultadoBusqueda(libro.getMaterial().getIdmaterial() , libro.getTitulo());
					result.add(itemResult);
				}
			break;
			case "CD":
				Logger.log4j.info("CD");
				List<Cd> cds = Cd.findAll();
				for (int i = 0; i < cds.size(); i++) {
					Cd cd = cds.get(i);
					ResultadoBusqueda itemResult = new ResultadoBusqueda(cd.getMedioDigital().getMaterial().getIdmaterial(), cd.getAlbum());
					result.add(itemResult);
			}
			break;
			case "DVD":
				Logger.log4j.info("DVD");
				List<Dvd> dvds = Dvd.findAll();
				for (int i = 0; i < dvds.size(); i++) {
					Dvd dvd = dvds.get(i);
					ResultadoBusqueda itemResult = new ResultadoBusqueda(dvd.getMedioDigital().getMaterial().getIdmaterial(), dvd.getTitulo());
					result.add(itemResult);
				}
			break;
			case "Mapa":
				Logger.log4j.info("Mapa");
				List<Mapa> mapas = Mapa.findAll();
				for (int i = 0; i < mapas.size(); i++) {
				Mapa mapa = mapas.get(i);
				ResultadoBusqueda itemResult = new ResultadoBusqueda(mapa.getMaterial().getIdmaterial(), mapa.getTitulo());
				result.add(itemResult);
			}
			break;
			case "Revista":
				Logger.log4j.info("Revista");
				List<Revista> revistas = Revista.findAll();
				for (int i = 0; i < revistas.size(); i++) {
					Revista revista = revistas.get(i);
					ResultadoBusqueda itemResult = new ResultadoBusqueda(revista.getHemerografia().getMaterial().getIdmaterial(), revista.getTitulo());
					result.add(itemResult);
				}
			break;
			case "Periodico":
				Logger.log4j.info("Periodico");
				List<Periodico> periodicos = Periodico.findAll();
				for (int i = 0; i < periodicos.size(); i++) {
					Periodico periodico = periodicos.get(i);
					ResultadoBusqueda itemResult = new ResultadoBusqueda(periodico.getHemerografia().getMaterial().getIdmaterial(), periodico.getTitular());
					result.add(itemResult);
				}
			break;
			case "Memoria":
				Logger.log4j.info("Memoria");
				List<Memoria> memorias = Memoria.findAll();
				for (int i = 0; i < memorias.size(); i++) {
					Memoria memoria = memorias.get(i);
					ResultadoBusqueda itemResult = new ResultadoBusqueda(memoria.getMaterial().getIdmaterial(), memoria.getTitulo());
					result.add(itemResult);
				}
			break;
			case "Obra Referencia":
				Logger.log4j.info("Obra Referencia");
				List<ObraReferencia> obrasReferencia = ObraReferencia.findAll();
				for (int i = 0; i < obrasReferencia.size(); i++) {
					ObraReferencia obraRef = obrasReferencia.get(i);
					ResultadoBusqueda itemResult = new ResultadoBusqueda(obraRef.getMaterial().getIdmaterial(), obraRef.getTitulo());
					result.add(itemResult);
				}
			break;
			case "Trabajos de Graduacion":
				Logger.log4j.info("Trabajos de Graduacion");
				List<TrabajoGraduacion> trabajosG = TrabajoGraduacion.findAll();
				for (int i = 0; i < trabajosG.size(); i++) {
					TrabajoGraduacion trabajoG = trabajosG.get(i);
					ResultadoBusqueda itemResult = new ResultadoBusqueda(trabajoG.getMaterial().getIdmaterial(), trabajoG.getTema());
					result.add(itemResult);
				}
			break;

		default:
			break;
		}
		
		renderJSON(gson.toJson(result));
	}
	
	
}
