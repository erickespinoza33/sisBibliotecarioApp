package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Application extends Controller {

    public static void index() {
    	Institucion institucion = new Institucion();
    	institucion.setNombreInstitucion("UCA");
    	institucion.setDireccionInstitucion("La Libertad");
    	institucion.setTelefonoInstitucion("2222-7777");
    	
    	Institucion institucion1 = new Institucion();
    	institucion1.setNombreInstitucion("UES");
    	institucion1.setDireccionInstitucion("San Salvador");
    	institucion1.setTelefonoInstitucion("2222-7777");
        render(institucion, institucion1);
    }
    
    public static void signin(){
    	render();
    }
}