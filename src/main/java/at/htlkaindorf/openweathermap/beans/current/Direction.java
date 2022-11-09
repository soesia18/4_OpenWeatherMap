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
public class Direction {
    @XmlAttribute
    private int value;
    @XmlAttribute
    private String code;
    @XmlAttribute
    private String name;
}
