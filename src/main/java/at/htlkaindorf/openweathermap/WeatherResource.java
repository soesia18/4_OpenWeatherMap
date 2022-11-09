package at.htlkaindorf.openweathermap;

import at.htlkaindorf.openweathermap.beans.current.Weather;
import at.htlkaindorf.openweathermap.beans.forecast.ForecastWeather;
import at.htlkaindorf.openweathermap.bl.XML_Access;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.FileNotFoundException;

@Path("/weather")
public class WeatherResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/current/{city}")
    public Response getCurrentWeather(@PathParam("city") String city, @QueryParam("lang") String lang) {
        try {
            Weather weather = XML_Access.getWeatherFromCity(city, lang);
            return Response.ok(weather).build();
        } catch (FileNotFoundException fnfe) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/forecast/{city}")
    public Response getForecastWeather(@PathParam("city") String city, @QueryParam("lang") String lang) {
        try {
            ForecastWeather weather = XML_Access.getForecastWeatherFromCity(city, lang);
            return Response.ok(weather).build();
        } catch (FileNotFoundException fnfe) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}