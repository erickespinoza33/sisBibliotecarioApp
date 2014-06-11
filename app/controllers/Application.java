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
    	
    	List<Memoria> memorias = Memoria.findAll();
    	for (Memoria memoria : memorias) {
    		Logger.log4j.info(memoria.getAutor());			
		}
        render();
        
    }
    
    public static void signin(){
    	render();
    }
}