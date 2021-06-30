package com.epam.diamondfund.JSONParser;

import com.epam.diamondfund.Gemstone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "gemstone"
})
@XmlRootElement(name = "gem")
public class Gem {

    @XmlElement(required = true)
    protected List<Gemstone> gemstone;


    public List<Gemstone> getGemstone() {
        if (gemstone == null) {
            gemstone = new ArrayList<>();
        }
        return this.gemstone;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "gemstone=" + gemstone +
                '}';
    }
}
