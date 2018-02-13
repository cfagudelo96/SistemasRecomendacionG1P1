package models;

import javax.persistence.*;

import io.ebean.*;
import play.data.validation.*;

@Entity
public class User extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String userProfileId;

    public String gender;

    public Integer age;

    public String country;
}
