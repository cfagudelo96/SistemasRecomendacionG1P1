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

    public Result signup() {
        Form<User> userForm = form.bindFromRequest();
        try {
            if (userForm.hasErrors()) {
                return badRequest(views.html.login.signup.render(userForm));
            } else {
                User user = userForm.get();
                user.save();
                flash("success", "Tu usuario fue creado exitósamente");
                return redirect("/login");
            }
        } catch (Exception e) {
            flash("error", "Ocurrió un error al tratar de registrarte: " + e.getMessage());
            return badRequest(views.html.login.signup.render(userForm));
        }
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
                return redirect("/");
            }
        }
    }

    public Result logout() {
        session().clear();
        return redirect("/");
    }
}
