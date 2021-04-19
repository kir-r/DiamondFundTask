package com.epam.diamondfund.JSONParser;
import com.epam.diamondfund.Gemstone;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = {
//        "gemstone"
//})
@XmlRootElement(name = "gem")
public class Gem {
    @XmlElement(required = true)
    List<Gemstone> listOfGemstones;

    public Gem() {
    }

    public List<Gemstone> getListOfGemstones() {
        if (listOfGemstones == null) {
            listOfGemstones = new ArrayList<>();
        }
        return this.listOfGemstones;
    }

    @Override
    public String toString() {
        return "Gem:\n" + "listOfGemstones=" + listOfGemstones.toString();
    }
}
