package com.epam.diamondfund.JSONParser;
import com.epam.diamondfund.Gem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLtoJSONParser {
    Gem gem;
    private Logger logger = LogManager.getLogger(XMLtoJSONParser.class);

    public void parseXMLtoJSON() {
        try (FileReader reader = new FileReader("src\\main\\java\\resource\\diamondfund.xml")) {
            JAXBContext context = JAXBContext.newInstance(Gem.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            gem = (Gem) unmarshaller.unmarshal(reader);
            createJSONFromObject();
        } catch (JAXBException | IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void createJSONFromObject() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src\\main\\java\\resource\\diamondfundJSON.json")) {
            writer.write(gson.toJson(gem));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
