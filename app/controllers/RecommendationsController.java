package controllers;

import models.Recommender;
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

import java.util.List;

public class RecommendationsController extends Controller {
    public Result userToUserRecommendation(int numberNeighbors) {
        try {
            Recommender r = new Recommender();
            DataModel model= new FileDataModel(new File(""),"\t");
            UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(numberNeighbors, similarity, dataModel);
            UserBasedRecommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
            Long uid = Long.parseLong(session("id"));
            List<RecommendedItem> recommendedItems = recommender.recommend(uid, 2);
            return ok(recommendedItems.toString());
        } catch (Exception e) {
            return badRequest();
        }
    }

    public Result loadData() {
        try {
            Recommender r = new Recommender();
            r.loadData();
            return ok("Información cargada");
        } catch (Exception e) {
            return badRequest("Ocurrió un error: " + e.getMessage());
        }
    }

    public Result recommend(int numberNeighbors) {
        return userToUserRecommendation(numberNeighbors);
    }
}
