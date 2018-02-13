package models;

import javax.persistence.*;

import io.ebean.*;
import play.data.validation.*;

@Entity
public class Track extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String userProfileId;

    public String musicbrainzArtistId;

    public String artistName;

    public String musicbrainzTrackId;

    public String trackName;
}
