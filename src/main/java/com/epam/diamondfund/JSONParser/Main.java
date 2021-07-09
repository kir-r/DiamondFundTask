package com.epam.diamondfund.JSONParser;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**Написать приложение, которое превращает XML файл из задания по XML в JSON файл и сохраняет его в системе
Написать парсер, который парсит полученный в п. 1 JSON и создает из него коллекцию объектов*/

public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        XMLtoJSONParser xMLtoJSONParser = new XMLtoJSONParser();
        xMLtoJSONParser.parseXMLtoJSON();

        JSONParser jSONParser = new JSONParser();
        jSONParser.parseJSONFile();
    }
}
