package models;

import javax.persistence.*;

import io.ebean.*;

import play.data.validation.*;

import java.util.*;

@Entity
@Table(name="custom_user")
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

    public List<Preference> topPreferences() {

        List<Preference> preferences =  Preference.find.query().where().and(Expr.eq("userId", id), Expr.and(Expr.ne("preference", 1),Expr.ne("preference", 2))).findList();

        return preferences;
    }

    public List<Preference> preferences() {

        return Preference.find.query().where().eq("userId", id).findList();
    }

}
