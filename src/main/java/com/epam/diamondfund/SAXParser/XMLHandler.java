package com.epam.diamondfund.SAXParser;

import com.epam.diamondfund.Gemstone;
import com.epam.diamondfund.VisualParameters;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
    private Gemstone gemstone;
    private VisualParameters visualParameters;
    private String parameter;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        parameter = qName;
        if (qName.equals("gemstone")) {
            gemstone = new Gemstone();

        } else if (qName.equals("VisualParameters")) {
            visualParameters = new VisualParameters();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String information = new String(ch, start, length);
        information = information.replace("\n", "").trim();
        if (!information.isEmpty()) {
            if (parameter.equals("name")) {
                gemstone.setName(information);
            }

            if (parameter.equals("preciousness")) {
                gemstone.setPreciousness(information);
            }
            if (parameter.equals("origin")) {
                gemstone.setOrigin(information);
            }
            if (parameter.equals("color")) {
                visualParameters.setColor(information);
            }
            if (parameter.equals("transparency")) {
                visualParameters.setTransparency(information);
            }
            if (parameter.equals("cutting")) {
                visualParameters.setCutting(information);
            }
            if (parameter.equals("value")) {
                gemstone.setValue(information);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("gemstone")) {
            gemstone.setVisualParameters(visualParameters);
            Main.listOfGemstone.add(gemstone);
        }
    }
}
