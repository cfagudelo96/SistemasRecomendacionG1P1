package models;

import org.apache.mahout.cf.taste.impl.model.jdbc.PostgreSQLJDBCDataModel;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Recommender {

    public Recommender() {}

    public PostgreSQLJDBCDataModel getDataModel() {
        try {
            PostgreSQLJDBCDataModel dataModel = new PostgreSQLJDBCDataModel(getDataSource());
            return dataModel;
        } catch (Exception e) {
            return null;
        }
    }

    public void loadData() throws Exception {
        //loadInitialData();
        loadPreferenceData();
    }

    private void loadInitialData() throws Exception {
        Path path = Paths.get("./data/userid-timestamp-artid-artname-traid-traname.tsv");
        Files.lines(path).forEach((line) -> {
            String[] information = line.split("\t");
            createUser(information[0]);
            createArtist(information[2], information[3]);
        });
    }

    private void loadPreferenceData() throws Exception {
        Path path = Paths.get("./data/transformed_data.tsv");
        Files.lines(path).forEach((line) -> {
            String[] information = line.split("\t");
            User user = User.find.query().where().eq("userProfileId", information[0]).findOne();
            Artist artist = Artist.find.query().where().eq("musicbrainzArtistId", information[1]).findOne();
            Double value = Double.parseDouble(information[2]);
            if(user != null && artist != null) {
                Preference preference = Preference.find.query().where().eq("userId", user.id).and().eq("itemId", artist.id).findOne();
                if(preference != null) {
                    preference.preference = value;
                    preference.update();
                } else {
                    preference = new Preference();
                    preference.userId = user.id;
                    preference.itemId = artist.id;
                    preference.preference = value;
                    preference.save();
                }
            }
        });
    }

    private void createUser(String userProfileId) {
        User user = User.find.query().where().eq("userProfileId", userProfileId).findOne();
        if (user == null) {
            user = new User();
            user.userProfileId = userProfileId;
            user.save();
        }
    }

    private void createArtist(String musicbrainzArtistId, String artistName) {
        Artist artist = Artist.find.query().where().eq("musicbrainzArtistId", musicbrainzArtistId).findOne();
        if (artist == null) {
            artist = new Artist();
            artist.artistName = artistName;
            artist.musicbrainzArtistId = musicbrainzArtistId;
            artist.save();
        }
    }

    private DataSource getDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName("lohalhost");
        dataSource.setPortNumber(5432);
        dataSource.setDatabaseName("SistemasRecomendacion");
        dataSource.setUser("SistemasRecomendacion");
        dataSource.setPassword("Grupo1");
        return dataSource;
    }
}
