package controllers;

import com.google.gson.Gson;

import models.UserInfo;
import models.Usuario;
import play.Logger;
import play.Play;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.mvc.*;
 
public class Security extends Secure.Security {
	final static Gson gson = new Gson();
    
	static boolean authenticate(String usuario, String password) {
		Logger.log4j.info(usuario);
		Logger.log4j.info(password);

		Usuario user = Usuario.find("byNombreusuario", usuario).first();
		Logger.log4j.info(user.getNombreusuario());

		if (user != null && user.getContrasena().equals(password)) {
			UserInfo userinfo = new UserInfo(user.getIdUsuario(), user.getNombres(), user.getApellidos(), user.getRol().getRol());
			setUserSession(userinfo);			
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
		if(usuario.getRol().getRol().equals("Prestamista")){
			Play.configuration.setProperty("db.user", "Prestamista");
			Play.configuration.setProperty("db.pass", "Pres123");
			Play.configuration.setProperty("db.default.schema", "Prastamista");			
		}else{
			if(usuario.getRol().getRol().equals("Bibliotecologo")){
				Play.configuration.setProperty("db.user", "Bibliotecologo");
				Play.configuration.setProperty("db.pass", "Biblio123");
				Play.configuration.setProperty("db.default.schema", "Bibliotecologo");			
			}else{
				Play.configuration.setProperty("db.user", "Administrador");
				Play.configuration.setProperty("db.pass", "Admindb123");
				Play.configuration.setProperty("db.default.schema",	"Administrador");
			}
		}


		JPA.entityManagerFactory = null;
		JPAPlugin plugin = new JPAPlugin();
		plugin.onApplicationStart();

		return true;
	}

	public static boolean setDBSchema() {
		// Play.configuration.setProperty("hibernate.connection.url ",
		// "jdbc:oracle:thin:@192.168.1.14:1521/xe");

		Play.configuration.setProperty("db.user", "Administrador");
		Play.configuration.setProperty("db.pass", "Admindb123");
		Play.configuration.setProperty("db.default.schema",	"Administrador");
		
		
		Play.configuration.setProperty("%production.db.user", "Administrador");
		Play.configuration.setProperty("%production.db.pass", "Admindb123");
		Play.configuration.setProperty("%production.db.default.Administrador",
				"adminuser");
		

		JPA.entityManagerFactory = null;
		JPAPlugin plugin = new JPAPlugin();
		plugin.onApplicationStart();

		return true;
	}
	
	/**
	 * Set user session.
	 *
	 * @param user the new user session
	 * @return 
	 */
	public static int setUserSession(UserInfo user) {
		Logger.log4j.info("Setting user information in session scope");
		session.put("userInfo", gson.toJson(user));
		return 0;
	}
	
	/**
	 * User logged.
	 */
	public static void userLogged() {
		Gson gson = new Gson();
		String userJSON = session.get("userInfo");

		UserInfo user = gson.fromJson(userJSON, UserInfo.class);
		renderJSON(user);
	}
	
	/**
	 * Sign out.
	 */
	public static void signOut() {
		Logger.log4j.info("Clear session vars");
		session.clear();
		
		redirect("/");
	}

}