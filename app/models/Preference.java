package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taste_preferences")
public class Preference extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public Long userId;

    @Constraints.Required
    public Long itemId;

    @Constraints.Required
    public Double preference;

    public Preference (Long userId, Long itemId, Double preference){
        this.userId = userId;
        this.itemId = itemId;
        this.preference = preference;
    }

    public static final Finder<Long, Preference> find = new Finder<>(Preference.class);
}
