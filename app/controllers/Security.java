package controllers;

import models.Usuario;
import play.Logger;
import play.Play;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.mvc.*;
 
public class Security extends Secure.Security {
    
	static boolean authenticate(String usuario, String password) {
		Logger.log4j.info(usuario);
		Logger.log4j.info(password);

		Usuario user = Usuario.find("byNombreusuario", usuario).first();
		Logger.log4j.info(user.getNombreusuario());

		if (user != null && user.getContrasena().equals(password)) {
			return setDBSchema(user);

		} else {
			return false;
		}
	}

	static void onDisconnected() {
		setDBSchema();
		Application.redirect("/");
		
	}

	static void onAuthenticated() {
		Application.index();
	}


	public static boolean setDBSchema(Usuario usuario) {
		// Play.configuration.setProperty("hibernate.connection.url ",
		// "jdbc:oracle:thin:@192.168.1.14:1521/xe");

		Play.configuration.setProperty("db.user", usuario.getNombreusuario());
		Play.configuration.setProperty("db.pass", usuario.getContrasena());
		Play.configuration.setProperty("db.default.schema", usuario.getRol().getRol());

		JPA.entityManagerFactory = null;
		JPAPlugin plugin = new JPAPlugin();
		plugin.onApplicationStart();

		return true;
	}

	public static boolean setDBSchema() {
		// Play.configuration.setProperty("hibernate.connection.url ",
		// "jdbc:oracle:thin:@192.168.1.14:1521/xe");

		Play.configuration.setProperty("db.user", "adminuser");
		Play.configuration.setProperty("db.pass", "adminuser");
		Play.configuration.setProperty("db.default.schema",
				"adminuser");
		
		
		Play.configuration.setProperty("%production.db.user", "adminuser");
		Play.configuration.setProperty("%production.db.pass", "adminuser");
		Play.configuration.setProperty("%production.db.default.schema",
				"adminuser");
		

		JPA.entityManagerFactory = null;
		JPAPlugin plugin = new JPAPlugin();
		plugin.onApplicationStart();

		return true;
	}
}