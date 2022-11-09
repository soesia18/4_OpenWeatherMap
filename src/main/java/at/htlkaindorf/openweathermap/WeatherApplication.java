package at.htlkaindorf.openweathermap;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@WebListener
@ApplicationPath("/api")
public class WeatherApplication extends Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }
}