package com.lucenesearch.util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucenesearch.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParser {

// The parseJsonFile method -> takes a file path as input,
//                          -> reads the JSON data from the file,
//                          -> and converts it into a List of Product objects

    public static List<Product> parseJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // ObjectMapper class -> is used for JSON deserialization
        File jsonFile = new File(filePath);
        return objectMapper.readValue(jsonFile, new TypeReference<List<Product>>() {});
        // new TypeReference<List<Product>>() {} is used to specify the type of the object to deserialize.
        // (It's basically a way to handle generic types like List<Product> during deserialization.)
    }
}

