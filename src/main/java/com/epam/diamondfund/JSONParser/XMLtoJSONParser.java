package com.epam.diamondfund.JSONParser;
import com.epam.diamondfund.JSONParser.Gem;

import com.epam.diamondfund.Gemstone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.DocumentType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLtoJSONParser {
    Gem gem;

    public void parseXMLtoJSON() {
        try {
            JAXBContext context = JAXBContext.newInstance(Gem.class);//?
            Unmarshaller unmarshaller = context.createUnmarshaller();

            gem = (Gem) unmarshaller.unmarshal(new File("src\\main\\java\\resource\\diamondfund.xml"));

//            Gem.listOfGemstones = ((JAXBElement<DocumentType>) context.createUnmarshaller().unmarshal(new File("src\\main\\java\\resource\\diamondfund.xml"))).getValue();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try (FileWriter fileWriter = new FileWriter("src\\main\\java\\resource\\JSONdiamondfund.json")) {
                fileWriter.write(gson.toJson(gem));
            } catch (IOException e) {
                Main.logger.error(e.getMessage());
            }
        } catch (JAXBException e) {
            Main.logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
