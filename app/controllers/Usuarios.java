package controllers;

import models.Usuario;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(Usuario.class)
public class Usuarios extends CRUD {

}
