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
public class Speed {
    @XmlAttribute
    private double value;
    @XmlAttribute
    private String unit;
    @XmlAttribute
    private String name;
}
