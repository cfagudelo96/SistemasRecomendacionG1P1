package controllers;

import models.Artist;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class ArtistsController extends Controller {
    private Form<Artist> form;

    @Inject
    public ArtistsController(final FormFactory formFactory) {
        this.form = formFactory.form(Artist.class);
    }

    public Result create() {
        Form<Artist> artistForm = form.bindFromRequest();
        try {
            if (artistForm.hasErrors()) {
                return badRequest(views.html.artists.create.render(artistForm));
            } else {
                Artist artist = artistForm.get();
                artist.save();
                return ok();
            }
        } catch (Exception e) {
            flash("error", "Ocurrió un error al tratar de registrar el artista: " + e.getMessage());
            return badRequest(views.html.artists.create.render(artistForm));
        }
    }
}
