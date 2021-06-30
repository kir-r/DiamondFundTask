package com.epam.diamondfund.JSONParser;

import com.epam.diamondfund.Gemstone;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class JSONParser {

    public void parseJSONFile() {
        Gem gems = null;
        try (FileReader reader = new FileReader("src\\main\\java\\resource\\diamondfundJSON.json")) {
            Gson gson = new Gson();
            gems = gson.fromJson(reader, Gem.class);
            System.out.println("parseJSONFile gems " + gems);
        } catch (IOException e) {
//            Main.logger.error(e.getMessage());
            e.printStackTrace();
        }

    }
}
