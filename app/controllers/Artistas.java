package controllers;

import play.mvc.With;
import models.Artista;

@With(Secure.class)
@CRUD.For(Artista.class)
public class Artistas extends CRUD{

}
