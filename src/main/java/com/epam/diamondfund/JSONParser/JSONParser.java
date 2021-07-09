package com.epam.diamondfund.JSONParser;

import com.epam.diamondfund.Gem;
import com.google.gson.Gson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;

public class JSONParser {
    private Logger logger = LogManager.getLogger(JSONParser.class);

    public void parseJSONFile() {
        Gem gem = null;
        try (FileReader reader = new FileReader("src\\main\\java\\resource\\diamondfundJSON.json")) {
            Gson gson = new Gson();
            gem = gson.fromJson(reader, Gem.class);
            logger.info("Parse JSON file gems " + gem);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
