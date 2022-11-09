package at.htlkaindorf.openweathermap.beans.current;

import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "current")
public class Weather {
    private City city;
    private Temperature temperature;
    private Humidity humidity;
    private Pressure pressure;
    private Wind wind;
    private Clouds clouds;

    public static void main(String[] args) {
        URI uri = URI.create("https://api.openweathermap.org/data/2.5/weather?q=Kaindorf%20an%20der%20Sulm&appid=f76fc912c1986b56ff6940c47c51186f&mode=xml");

        Weather weather = JAXB.unmarshal(uri, Weather.class);
        System.out.println(weather);
    }
}
