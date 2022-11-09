package at.htlkaindorf.openweathermap.beans.forecast;

import at.htlkaindorf.openweathermap.beans.current.Humidity;
import at.htlkaindorf.openweathermap.beans.current.Pressure;
import at.htlkaindorf.openweathermap.beans.current.Temperature;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Time {
    @XmlAttribute
    private String from;

    @XmlAttribute
    private String to;

    private Temperature temperature;
    private Humidity humidity;
    private Pressure pressure;
    private Clouds clouds;
    private WindSpeed windSpeed;
}
