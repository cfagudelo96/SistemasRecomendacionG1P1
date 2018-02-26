package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class LoginController extends Controller {
    private Form<User> form;

    @Inject
    public LoginController(final FormFactory formFactory) {
        this.form = formFactory.form(User.class);
    }

    public Result login() {
        Form<User> userForm = form.bindFromRequest();
        if (userForm.hasErrors()) {
            return badRequest(views.html.login.login.render(userForm));
        } else {
            User userFromForm = userForm.get();
            User user = User.authenticate(userFromForm.userProfileId);
            if(user == null){
                flash("error", "No se encontró el usuario");
                return badRequest(views.html.login.login.render(userForm));
            } else {
                session().clear();
                session().put("id", user.id.toString());
                session().put("userProfileId", user.userProfileId);
                return ok("Got user " + user);
            }
        }
    }

    public Result logout() {
        session().clear();
        return ok();
    }
}
