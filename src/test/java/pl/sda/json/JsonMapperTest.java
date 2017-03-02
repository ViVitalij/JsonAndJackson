package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import pl.sda.AddressBuilder;
import pl.sda.User;
import pl.sda.UserBuilder;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by m.losK on 2017-03-02.
 */
public class JsonMapperTest {
    @Test
    public void test1() throws IOException {
        String jsonToDeserialize = "{\"firstName\":\"Mateusz\",\"lastName\":\"Loska\",\"addresses\":{\"Work\":{\"street\":\"Al.Solidarnosci\",\"code\":\"00-020\",\"city\":\"Warszawa\"},\"Home\":{\"street\":\"Sw.Marcin\",\"code\":\"60-070\",\"city\":\"Poznan\"}},\"childrenNames\":[\"Mateuszek\",\"Anusia\"]}\n";

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(jsonToDeserialize, User.class);

        Assert.assertEquals("Mateusz", user.getFirstName());

        Assert.assertNotNull(user.getChildrenNames());
        Assert.assertTrue(user.getChildrenNames() != null);

        Assert.assertTrue(user.getChildrenNames().size() == 2);
        Assert.assertEquals(Arrays.asList("Mateuszek", "Anusia"), user.getChildrenNames());
    }

    @Test
    public void test2() throws IOException {
        User user = new UserBuilder().withFirstName("Mateusz").withLastName("Loska")
                .withAddress("Home", new AddressBuilder().withCity("Poznan").withStreet("Sw.Marcin").withPostalCode("60-070").build())
                .withAddress("Work", new AddressBuilder().withCity("Warszawa").withStreet("Al.Solidarnosci").withPostalCode("00-020").build())
                .withChildrenNames(Arrays.asList("Mateuszek", "Anusia"))
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String serializedObject = mapper.writeValueAsString(user);

        Assert.assertTrue(serializedObject.contains("\"firstName\":\"Mateusz\""));
        Assert.assertTrue(serializedObject.contains("Loska"));
        Assert.assertTrue(serializedObject.contains("Anusia"));
    }

    @Test
    public void test3() throws IOException {
        User user = new UserBuilder().withFirstName("Mateusz").withLastName("Loska")
                .withAddress("Home", new AddressBuilder().withCity("Poznan").withStreet("Sw.Marcin").withPostalCode("60-070").build())
                .withAddress("Work", new AddressBuilder().withCity("Warszawa").withStreet("Al.Solidarnosci").withPostalCode("00-020").build())
                .withChildrenNames(null)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String serializedObject = mapper.writeValueAsString(user);
        System.out.println(serializedObject);
    }
}
