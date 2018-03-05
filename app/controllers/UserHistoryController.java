package controllers;

import models.User;
import models.Artist;


import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.*;

public class UserHistoryController extends Controller {
    private Form<User> form;

    @Inject
    public UserHistoryController(final FormFactory formFactory) {
        this.form = formFactory.form(User.class);
    }

    public Result index() {
        if (session().get("id") != null) {
            User user = User.find.byId(Long.parseLong(session().get("id")));
            List<Artist> list = Artist.find.all();
            return ok(views.html.userHistory.index.render(user,list));
        } else {
            return redirect("/login");
        }
    }

}
