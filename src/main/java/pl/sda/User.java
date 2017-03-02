package pl.sda;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by m.losK on 2017-03-02.
 */

//information for mapper to omit null values //NON_EMPTY takes account NON_NULL
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class User {
    private String firstName;
    private String lastName;
    private Map<String, Address> addresses = new HashMap<>();
    private List<String> childrenNames = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, Address> addresses) {
        this.addresses = addresses;
    }

    public List<String> getChildrenNames() {
        return childrenNames;
    }

    public void setChildrenNames(List<String> childrenNames) {
        this.childrenNames = childrenNames;
    }
}
