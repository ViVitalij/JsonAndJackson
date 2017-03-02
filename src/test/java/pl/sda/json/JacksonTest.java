package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by m.losK on 2017-03-02.
 */
public class JacksonTest {
    @Test
    public void test1() throws IOException {
        String jsonToDeserialize = "{\"originalTitle\":\"Saving Private Ryan\",\"plTitle\":\"Szeregowiec Ryan\",\"director\":{\"firstName\":\"Steven\",\"lastName\":\"Spielberg\"}}";

        ObjectMapper objectMapper = new ObjectMapper();
        Movie movie = objectMapper.readValue(jsonToDeserialize, Movie.class);

        Assert.assertEquals("Saving Private Ryan", movie.getOriginalTitle());
        Assert.assertEquals("Szeregowiec Ryan", movie.getPlTitle());
        Assert.assertEquals("Steven", movie.getDirector().getFirstName());
        Assert.assertEquals("Spielberg", movie.getDirector().getLastName());
    }

    @Test
    public void test2() throws IOException {
        String jsonToDeserialize = "{\"originalTitle\":\"Empire Strikes Back\",\"plTitle\":\"Imperium kontratakuje\",\"director\":{\"firstName\":\"Steven\",\"lastName\":\"Spielberg\"}, \"boxOffice\":538375067}";

        ObjectMapper objectMapper = new ObjectMapper();
        Movie movie = objectMapper.readValue(jsonToDeserialize, Movie.class);

        Assert.assertEquals("Empire Strikes Back", movie.getOriginalTitle());
        Assert.assertEquals("Imperium kontratakuje", movie.getPlTitle());
        Assert.assertEquals("Steven", movie.getDirector().getFirstName());
        Assert.assertEquals("Spielberg", movie.getDirector().getLastName());
        Assert.assertEquals(538375067, movie.getBoxOffice());
    }
}
