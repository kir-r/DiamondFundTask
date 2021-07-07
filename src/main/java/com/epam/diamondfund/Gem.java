package com.epam.diamondfund;

import com.epam.diamondfund.Gemstone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gem", namespace = "https://diamondss.com/", propOrder = {
        "gemstone"
})

@XmlRootElement(name = "gem", namespace = "https://diamondss.com/")
public class Gem {
    @XmlElement(required = true, namespace = "https://diamondss.com/")
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
                "gemstone=" + getGemstone() +
                '}';
    }
}
