package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Recommender;
import org.apache.mahout.cf.taste.impl.model.jdbc.PostgreSQLJDBCDataModel;
import play.libs.Json;

import models.User;
import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result login(){
        User userFromForm = Json.fromJson(request().body().asJson(), User.class);
        User user = User.authenticate(userFromForm.userProfileId);
        if(user == null){
            ObjectNode error = Json.newObject();
            error.put("message","El usuario no existe");
            return badRequest(Json.toJson(error));
        }
        session().clear();
        session().put("id", user.id.toString());
        session().put("userProfileId", user.userProfileId);

        return ok(index.render("Your new application is ready."));
    }

    public Result test() {
        Recommender recommender = new Recommender();
        PostgreSQLJDBCDataModel pg = recommender.getDataModel();
        if(pg != null) {
            return ok("Si se pudo");
        } else {
            return ok("No se pudo");
        }
    }
}
