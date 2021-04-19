package com.epam.diamondfund.DOMParser;

import com.epam.diamondfund.Gemstone;
import com.epam.diamondfund.VisualParameters;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Gemstone> listOfGemstone = new ArrayList<>();
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        BasicConfigurator.configure();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src\\main\\java\\resource\\diamondfund.xml"));

        NodeList gemElements = document.getElementsByTagName("gemstone");

        for (int i = 0; i < gemElements.getLength(); i++) {
            Gemstone gemstone = new Gemstone();
            VisualParameters visualParameters = new VisualParameters();

            Node gemstoneNode = gemElements.item(i);
            NodeList childNodes = gemstoneNode.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);
                String content = childNode.getTextContent().trim();
                switch (childNode.getNodeName()) {
                    case "name":
                        gemstone.setName(content);
                        break;
                    case "preciousness":
                        gemstone.setPreciousness(content);
                        break;
                    case "origin":
                        gemstone.setOrigin(content);
                        break;
                    case "VisualParameters":
                        NodeList visualParametersNodeList = childNode.getChildNodes();
                        for (int k = 0; k < visualParametersNodeList.getLength(); k++) {
                            Node grandChild = visualParametersNodeList.item(k);
                            String secondContent = grandChild.getTextContent().trim();
                            switch (grandChild.getNodeName()) {
                                case "color":
                                    visualParameters.setColor(secondContent);
                                    break;
                                case "transparency":
                                    visualParameters.setTransparency(secondContent);
                                    break;
                                case "cutting":
                                    visualParameters.setCutting(secondContent);
                                    break;
                            }
                        }
                        break;
                    case "value":
                        gemstone.setValue(content);
                        break;
                }
            }
            gemstone.setVisualParameters(visualParameters);
            listOfGemstone.add(gemstone);
            logger.info(gemstone);
        }
    }
}