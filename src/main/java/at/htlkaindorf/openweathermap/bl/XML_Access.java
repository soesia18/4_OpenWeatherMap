package at.htlkaindorf.openweathermap.bl;

import at.htlkaindorf.openweathermap.beans.current.Weather;
import at.htlkaindorf.openweathermap.beans.forecast.Forecast;
import at.htlkaindorf.openweathermap.beans.forecast.ForecastWeather;
import jakarta.xml.bind.JAXB;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;

public class XML_Access {
    public static Weather getWeatherFromCity(String city, String lang) throws FileNotFoundException {
        city = city.replace(" ", "%20");
        URI uri = URI.create("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=f76fc912c1986b56ff6940c47c51186f&mode=xml&units=metric&lang=" + lang);
        Weather weather = JAXB.unmarshal(uri, Weather.class);
        System.out.println(weather);
        return weather;
    }

    public static ForecastWeather getForecastWeatherFromCity(String city, String lang) throws FileNotFoundException {
        city = city.replace(" ", "%20");
        URI uri = URI.create("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=f76fc912c1986b56ff6940c47c51186f&mode=xml&units=metric&lang=" + lang);
        ForecastWeather weather = JAXB.unmarshal(uri, ForecastWeather.class);
        System.out.println(weather);
        return weather;
    }
}
