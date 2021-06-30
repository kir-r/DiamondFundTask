package com.epam.diamondfund.JSONParser;
import com.epam.diamondfund.JSONParser.Gem;

import com.epam.diamondfund.Gemstone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.DocumentType;

import org.json.JSONObject;
import org.json.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLtoJSONParser {
    Gem gem;

    public void parseXMLtoJSON() {
        try (FileReader reader = new FileReader("src\\main\\java\\resource\\diamondfund.xml")) {
            JAXBContext context = JAXBContext.newInstance(Gem.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            gem = (Gem) unmarshaller.unmarshal(reader);
            System.out.println("parseXMLtoJSON gem " + gem);
            createJSONFromObject();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
//            Main.logger.error(e.getMessage());
        }
    }
    private void createJSONFromObject() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src\\main\\java\\resource\\diamondfundJSON.json")) {
            writer.write(gson.toJson(gem));
        } catch (IOException e) {
            e.printStackTrace();
//            Main.logger.error(e.getMessage());
        }
    }
}
