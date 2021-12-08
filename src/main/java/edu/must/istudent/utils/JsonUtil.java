/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.must.istudent.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiTech
 */
public class JsonUtil {

    final static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) {
        try {
            return objectMapper.readTree(src);
        } catch (JsonProcessingException ex) {
            System.out.println("JsonUtil parse | " + ex);
        }
        return null;
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws IllegalArgumentException, JsonProcessingException {
        return objectMapper.treeToValue(node, clazz);
    }
}
