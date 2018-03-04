package controllers;

import io.ebean.Expr;
import models.Preference;
import models.Recommender;
import models.User;
import models.Artist;

import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.Iterator;
import java.util.List;

public class RecommendationsController extends Controller {
    public Result userToUserRecommendation(int numberNeighbors) {
        try {
            DataModel model = Recommender.getInstance().getDataModel();
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(numberNeighbors, similarity, model);
            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
            Long uid = Long.parseLong(session("id"));
            List<RecommendedItem> recommendedItems = recommender.recommend(uid, 2);

            String vecinos = "";

            String artistas = "";

            int numeroVecinos = neighborhood.getUserNeighborhood(uid).length;

            for ( int i = 0; i< numeroVecinos; i++) {
                vecinos += " - " + User.find.query().where().eq("id", neighborhood.getUserNeighborhood(uid)[i]).findOne().userProfileId;
            }

            Iterator<RecommendedItem> recommendedItemIterator = recommendedItems.iterator();
            while (recommendedItemIterator.hasNext()) {
                RecommendedItem item = recommendedItemIterator.next();

                artistas += " - " + Artist.find.query().where().eq("id",item.getItemID()).findOne().artistName;
            }

            return ok(views.html.index.render("Logueate en el sistema para comenzar a recibir recomendaciones sobre artistas",artistas,vecinos));
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest();
        }
    }

    public Result temp() {
        List<User> users = User.find.all();
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            int countNoUnos = Preference.find.query().where().and(Expr.eq("user_id", user.id), Expr.ne("preference", 1)).findCount();
            List<Preference> preferences = Preference.find.query().where().and(Expr.eq("user_id", user.id), Expr.eq("preference", 1)).findList();
            int porcentaje = (int) (countNoUnos * 0.1);
            int cantidadAEliminar = preferences.size() - porcentaje;
            Iterator<Preference> preferenceIterator = preferences.iterator();
            int eliminadas = 0;
            while (preferenceIterator.hasNext() && eliminadas <= cantidadAEliminar) {
                Preference preference = preferenceIterator.next();
                preference.delete();
                eliminadas++;
            }
        }
        return ok("Se eliminó a la verga");
    }

    public Result recommend(int numberNeighbors) {
        return userToUserRecommendation(numberNeighbors);
    }
}
