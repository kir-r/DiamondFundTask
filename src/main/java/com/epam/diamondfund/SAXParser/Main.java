package com.epam.diamondfund.SAXParser;

import com.epam.diamondfund.Gemstone;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 Создать файл XML и схему XSD к нему
 При разработке XSD использовать простые и комлексные типы, перечисления, шаблоны и предельные значения
 Сгенерировать Java class соответствующий описанию
 Написать приложения для парсинга XML документы и создание коллекции по данным из XML файлаю Для разбора использовать SAX, DOM, StAX парсеры. Для сортировки объектов использовать интерфейс Comparator
 Проверить XML с помощью XSD
 Реализовать метод для преобразования XML документа
 Описание Алмазный фонд:

 Name - Наименование камня
 Preciousness - Может быть драгоценным, либо полудрагоценным
 Origin - Место добычи
 Visual parameters (несколько для каждого камня) - Цвет (несколько вариантов), Прозрачность (в процентах от 0 до 100), Способ огранки (количество граней)
 Value - Вес камня в каратах
 Корневой элемент Gem

 С помощью XSLT преобразовать XML файл в формат XML, где корневым элементом будет Origin
 */

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

public class Main {
    static ArrayList<Gemstone> listOfGemstone = new ArrayList<>();
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        BasicConfigurator.configure();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler xmlHandler = new XMLHandler();
        parser.parse(new File("src\\main\\java\\resource\\diamondfund.xml"), xmlHandler);

        for (Gemstone gemstone : listOfGemstone) {
            logger.info(gemstone);
        }
    }
}
