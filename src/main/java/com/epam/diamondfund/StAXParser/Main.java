package com.epam.diamondfund.StAXParser;

import com.epam.diamondfund.Gemstone;
import com.epam.diamondfund.VisualParameters;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

//https://www.baeldung.com/java-stax

public class Main {
    private static ArrayList<Gemstone> listOfGemstone = new ArrayList<>();
    static Gemstone gemstone;
    static VisualParameters visualParameters;
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("src\\main\\java\\resource\\diamondfund.xml"));

            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "gemstone":
                            gemstone = new Gemstone();
                            break;
                        case "name":
                            nextEvent = reader.nextEvent();
                            gemstone.setName(nextEvent.asCharacters().getData());
                            break;
                        case "preciousness":
                            nextEvent = reader.nextEvent();
                            gemstone.setPreciousness(nextEvent.asCharacters().getData());
                            break;
                        case "origin":
                            nextEvent = reader.nextEvent();
                            gemstone.setOrigin(nextEvent.asCharacters().getData());
                            break;
                        case "VisualParameters":
                            visualParameters = new VisualParameters();
                            break;
                        case "color":
                            nextEvent = reader.nextEvent();
                            visualParameters.setColor(nextEvent.asCharacters().getData());
                            break;
                        case "transparency":
                            nextEvent = reader.nextEvent();
                            visualParameters.setTransparency(nextEvent.asCharacters().getData());
                            break;
                        case "cutting":
                            nextEvent = reader.nextEvent();
                            visualParameters.setCutting(nextEvent.asCharacters().getData());
                            break;
                        case "value":
                            nextEvent = reader.nextEvent();
                            gemstone.setValue(nextEvent.asCharacters().getData());
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();

                    if (endElement.getName().getLocalPart().equals("gemstone")) {
                        gemstone.setVisualParameters(visualParameters);
                        listOfGemstone.add(gemstone);
                        logger.info(gemstone);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            logger.error(e.getMessage());
        }
    }
}