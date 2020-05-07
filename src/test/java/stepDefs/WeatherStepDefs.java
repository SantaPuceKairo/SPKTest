package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import model.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import requesters.WeatherRequester;

import java.sql.SQLOutput;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private String cityName; //iznes pirms funkcijām, lai nav jādefinē funkcijās
    private String country;
    private Response response;


    @Given("show test name")
    public void show_test_name() {
        System.out.println("Weather forecast!");
    }

    @Given("city {string}") //taisa universiālu kodu nevis hard codē London city

    public void set_city(String cityName) {  //cityname tiks izmantots, kuru būs jānorāda
        this.cityName = cityName; // izmanto this lai norādātu, ka grib izmantot tiesi šo mainīgo konkrētajā klasē

    }

    @Given("country {string}")  //universāla valsts
    public void set_country(String country) {
        this.country = country;
    }


    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityName, country); //weather funkcija resultāts glabājas Response
        System.out.println(" Coordinate Lat: " + response.getCoord().getLat());
        System.out.println(" Coordinate Lon: " + response.getCoord().getLon());
        System.out.println(" Weather info: " + response.getWeathers());
        System.out.println(" Base is: " + response.getBase());
        System.out.println(" Main temp is: " + response.getMain().getTemp());
        System.out.println(" Main pressure is: " + response.getMain().getPressure());
        System.out.println(" Main humidity is: " + response.getMain().getHumidity());
        System.out.println("Main Min temp is " + response.getMain().getTemp_min());
        System.out.println("Main Max temp is " + response.getMain().getTemp_max());
        System.out.println("Visibility is: " + response.getVisibility());
        System.out.println(" Wind speed is: " + response.getWind().getSpeed());
        System.out.println("Wind deg is: " + response.getWind().getDeg());
        System.out.println("Clouds are: " + response.getClouds().getAll());
        System.out.println("Dt is: " + response.getDt());
        System.out.println("Sys type is: " + response.getSys().getType());
        System.out.println("Sys id is: " + response.getSys().getId());
        System.out.println("Sys message is: " + response.getSys().getMessage());
        System.out.println("Sys country is: " + response.getSys().getCountry());
        System.out.println("Sys sunrise is: " + response.getSys().getSunrise());
        System.out.println("Sys sunset is: " + response.getSys().getSunset());
        System.out.println("ID is: " + response.getId());
        System.out.println("City Name is: " + response.getName());
        System.out.println("Cod is: " + response.getCod());

    }

    @Then("lon is {float}")
    public void check_lon(float lon) {
        assertEquals(lon, response.getCoord().getLon(), "Wrong lon");
    }

    @Then("lat is {float}")
    public void check_lat(float lat) {
        assertEquals(lat, response.getCoord().getLat(), "Wrong lat");

    }

    @Then("weather is:")
    public void check_weather(Map<String, String> params) {
        Weather weather = response.getWeathers().get(0);
        assertEquals(Long.parseLong(params.get("id")), weather.getId(), "Wrong weather ID");
        //parsē Long uz String, pārbaude notiek uz id atslēgu

        assertEquals(params.get("main"), weather.getMain(), "Wrong MAIN info");
        //assertions tiek uzbīdīts uz import data  ar (Alt+Enter+Add)
        assertEquals(params.get("description"), weather.getDescription(), "Wrong description");
        assertEquals(params.get("icon"), weather.getIcon(), "Wrong  icon!");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        assertEquals(base, response.getBase(), "Wrong base");
    }

    @Then("temp is {float}")
    public void check_temp(float temp) {
        assertEquals(temp, response.getMain().getTemp(), "Temp is wrong");
    }

    @Then("pressure is {float}")
    public void check_pressure(float pressure) {
        assertEquals(pressure, response.getMain().getPressure(), "Wrong pressure!");
    }

    @Then("humidity is {float}")
    public void check_humidity(float humidity) {
        assertEquals(humidity, response.getMain().getHumidity(), "Wrong humidity");
    }

    @Then("temp_min {float}")
    public void check_temp_min(float temp_min) {
        assertEquals(temp_min, response.getMain().getTemp_min(), "Wrong Min temp!");
    }

    @Then("temp_max {float}")
    public void check_temp_max(float temp_max) {
        assertEquals(temp_max, response.getMain().getTemp_max(), "Wrong max temp!");
    }

    @Then("visibility is {int}")
    public void check_visibility(int visibility) {
        assertEquals(visibility, response.getVisibility(), "Wrong visibility");
    }

    @Then("speed is {float}")
    public void check_speed(float speed) {
        assertEquals(speed, response.getWind().getSpeed(), "Wrong speed");
    }

    @Then("deg is {int}")
    public void check_deg(int deg) {
        assertEquals(deg, response.getWind().getDeg(), "Wrong deg");
    }

    @Then("all is {int}")
    public void check_all(int all) {
        assertEquals(all, response.getClouds().getAll(), "Wrong clouds all info");
    }

    @Then("dt is {long}")
    public void check_dt(long dt) {
        assertEquals(dt, response.getDt(), "Wrong dt info");
    }

    @Then("type is {int}")
    public void check_type(int type) {
        assertEquals(type, response.getSys().getType(), "Wrong Type");
    }

    @Then("id_sys is {int}")
    public void check_id(int id) {
        assertEquals(id, response.getSys().getId(), "Wrong Sys id");
    }

    @Then("message is {float}")
    public void check_message(float message) {
        assertEquals(message, response.getSys().getMessage(), "Wrong message");
    }

    @Then("country is {string}")
    public void check_country(String country) {
        assertEquals(country, response.getSys().getCountry(), "Wrong country");
    }

    @Then("sunrise is {long}")
    public void check_sunrise(long sunrise) {
        assertEquals(sunrise, response.getSys().getSunrise(), "Wrong sunrise");
    }

    @Then("sunset is {long}")
    public void check_sunset(long sunset) {
        assertEquals(sunset, response.getSys().getSunset(), "Wrong sunset");
    }

    @Then("id is {long}")
    public void check_id(long id) {
        assertEquals(id, response.getId(), "Wrong Id");
    }

    @Then("name is {string}")
    public void check_names(String name) {
        assertEquals(name, response.getName(), "Wrong city Name");
    }

    @Then("cod is {long}")
    public void check_cod(long cod) {
        assertEquals(cod, response.getCod(), "Wrong Cod");
    }
}



