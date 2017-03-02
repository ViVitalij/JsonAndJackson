package pl.sda;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by m.losK on 2017-03-02.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setFirstName("Mateusz");
        user.setLastName("Loska");

        Address address = new Address();
        address.setStreet("Sw.Marcin");
        address.setPostalCode("60-070");
        address.setCity("Poznan");
        Address address2 = new Address();
        address2.setStreet("Al.Solidarnosci");
        address2.setPostalCode("00-020");
        address2.setCity("Warszawa");

        Map<String, Address> addresses = new HashMap<>();
        addresses.put("Home", address);
        addresses.put("Work", address2);

        user.setAddresses(addresses);

        List<String> childrenNames = Arrays.asList("Mateuszek", "Anusia");
        user.setChildrenNames(childrenNames);


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        System.out.println(json);
    }
}
