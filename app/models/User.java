package models;

import javax.persistence.*;

import io.ebean.*;

import play.data.validation.*;

@Entity
public class User extends Model {
    @Id
    public Long id;

    @Constraints.Required
    @Column(unique = true)
    public String userProfileId;

    public static final Finder<Long, User> find = new Finder<>(User.class);

    public static User authenticate(String userProfileId) {
        return find.query().where().eq("userProfileId", userProfileId).findOne();
    }
}
