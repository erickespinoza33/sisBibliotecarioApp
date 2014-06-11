package controllers;

import play.*;
import play.db.jpa.JPABase;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	/*
    	List<Prestamo> admin1 = Prestamo.findAll();
    	Logger.log4j.info(admin1.get(0).getBibliotecologo().getUsuario().getNombres());
    	*/
    	
    	/*
    	Rol rol = Rol.findById(2L);
    	List<Funcion> funcion = rol.getFuncions();
    	for (Funcion funcionItem : funcion) {
    		Logger.log4j.info(funcionItem.getFuncion());	
		}
		*/
    	/*
    	List<Mora> mora = Mora.findAll();
    	for (Mora moraItem : mora){
    		Logger.log4j.info(moraItem.getPrestamo().getPrestamista().getUsuario().getNombres());
    	}
    	*/
    	/*
    	List<Usuario> usuario = Usuario.findAll();
    	for (Usuario usuarioItem : usuario) {
    		Logger.log4j.info(usuarioItem.getNombres());			
		}
		*/
    	/*
    	List<Prestamista> prestamistas = Prestamista.findAll();
    	for (Prestamista prestamista : prestamistas) {
    		Logger.log4j.info(prestamista.getUsuario().getNombres());
			
		}
		*/
    	
    	/*
    	List<Memoria> memorias = Memoria.findAll();
    	for (Memoria memoria : memorias) {
    		Logger.log4j.info(memoria.getAutor());			
		}
    	*/
    	
    	/*
    	List<TrabajoGraduacion> trabajosG = TrabajoGraduacion.findAll();
    	for (TrabajoGraduacion trabajoGraduacion : trabajosG) {
			Logger.log4j.info(trabajoGraduacion.getTema());
    		List<Autor> autore = trabajoGraduacion.getAutors();
			for (Autor autor : autore) {
				Logger.log4j.info(autor);
			}
			
		}
		*/
    	
    	/*
    	List<ObraReferencia> obrasRef = ObraReferencia.findAll();
    	for (ObraReferencia obraReferencia : obrasRef) {
			Logger.log4j.info(obraReferencia.getTitulo());
    		List<Autor> autore = obraReferencia.getAutors();
			for (Autor autor : autore) {
				Logger.log4j.info(autor);
			}
			
		}
    	*/
    	
    	List<Mapa> mapas = Mapa.findAll();
    	for (Mapa mapa : mapas) {
			Logger.log4j.info(mapa.getTitulo());
			Logger.log4j.info(mapa.getCategoriamapa().getNombrecatmapa());
    		List<Autor> autore = mapa.getAutors();
			for (Autor autor : autore) {
				Logger.log4j.info(autor);
			}
			
		}
    	
    	render();
        
    }
    
    public static void signin(){
    	render();
    }
}