package models;

import javax.persistence.*;

import io.ebean.*;
import play.data.validation.*;

@Entity
public class Artist extends Model {
    @Id
    public Long id;

    @Constraints.Required
    @Column(unique = true)
    public String musicbrainzArtistId;

    @Constraints.Required
    public String artistName;

    public static final Finder<Long, Artist> find = new Finder<>(Artist.class);

}
