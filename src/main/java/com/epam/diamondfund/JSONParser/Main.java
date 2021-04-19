package com.epam.diamondfund.JSONParser;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.epam.diamondfund.Gemstone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        XMLtoJSONParser xMLtoJSONParser = new XMLtoJSONParser();
        xMLtoJSONParser.parseXMLtoJSON();

        JSONParser jSONParser = new JSONParser();
        jSONParser.parseJSONFile();
    }
}
