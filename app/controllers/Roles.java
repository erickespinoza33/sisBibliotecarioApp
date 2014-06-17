package controllers;

import play.mvc.With;
import models.Rol;

@With(Secure.class)
@CRUD.For(Rol.class)
public class Roles extends CRUD {

}
