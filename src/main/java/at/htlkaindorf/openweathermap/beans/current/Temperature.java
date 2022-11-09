package at.htlkaindorf.openweathermap.beans.current;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Temperature {
    @XmlAttribute
    private double value;
    @XmlAttribute
    private double min;
    @XmlAttribute
    private double max;
    @XmlAttribute
    private String unit;
}
