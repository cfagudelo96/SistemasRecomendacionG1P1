package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
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
