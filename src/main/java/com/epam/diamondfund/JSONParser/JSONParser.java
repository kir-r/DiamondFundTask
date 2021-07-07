package com.epam.diamondfund.JSONParser;

import com.epam.diamondfund.Gem;
import com.google.gson.Gson;

import java.io.*;

public class JSONParser {

    public void parseJSONFile() {
        Gem gem = null;
        try (FileReader reader = new FileReader("src\\main\\java\\resource\\diamondfundJSON.json")) {
            Gson gson = new Gson();
            gem = gson.fromJson(reader, Gem.class);
            Main.logger.info("Parse JSON file gems " + gem);
        } catch (IOException e) {
            Main.logger.error(e.getMessage());
        }
    }
}
