package models;

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
}
