package requesters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q=";
    private final String POSTFIX = "&appid=439d4b804bc8187953eb36d2a8c26a02";
    //metode
    public Response requestWeather(String city, String country) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate(); //izmanto gatavu bibliotēku
        String url = PREFIX + city + " , " + country.toLowerCase() + POSTFIX; //links sagatavots, kas nav konkrētai pilsētai/valstij


        String jsonToParse = restTemplate.getForEntity(url, String.class).getBody(); //restTemplate ir objekts, kas apstrādā jautajumus uz servera un sniedz atbildes
        //getForEntity (get question) jāizmanto, to parasti saka kolēgi, vai google vai springā var paskatīt ko izmantot lai iegūtu to un to
//url adrese, kur jautājums, string class ir tur kur rezultats, atbilde uz servera redz jasonu
        ObjectMapper objectMapper = new ObjectMapper(); // objekta kopija
        return objectMapper.readValue(jsonToParse, Response.class); // ko mēs parsējam//uz ko mēs gribam parsēt/ko vajag

    }
}
