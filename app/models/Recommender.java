package models;


import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import java.io.File;
import org.apache.mahout.cf.taste.model.DataModel;


public class Recommender {

    private static Recommender instance = null;

    private DataModel model;

    protected Recommender() {
        try {
            model= new FileDataModel(new File("public/data.csv"),";");
            System.out.println("Creado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Recommender getInstance() {
        if(instance == null) {
            instance = new Recommender();
        }
        return instance;
    }

    public DataModel getDataModel() {
        return model;
    }
}
