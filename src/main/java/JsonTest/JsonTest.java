/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonTest;

import edu.must.istudent.entity.StudentSubject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author HiTech
 */
public class JsonTest {

    final static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        return defaultObjectMapper;
    }
    
    public static JsonNode parse(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }
    
    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws IllegalArgumentException, JsonProcessingException {
        return objectMapper.treeToValue(node, clazz);
    }
    
    public static void main(String[] args) throws JsonProcessingException {
        String json = "[{\n"
                + "  \"code\": \"F.IT205\",\n"
                + "  \"credit\": 3,\n"
                + "  \"score\": 88\n"
                + "},{\n"
                + "  \"code\": \"F.CS203\",\n"
                + "  \"credit\": 3,\n"
                + "  \"score\": 84\n"
                + "},{\n"
                + "  \"code\": \"F.EE281\",\n"
                + "  \"credit\": 3,\n"
                + "  \"score\": 92\n"
                + "}]";

        JsonNode node = parse(json);
        
        JsonNode node1 = node.get(0);
        System.out.println(node.get(0));
        System.out.println(node.get(1));
        System.out.println(node.get(2));
        System.out.println(node1.get("code").asText());
        node.forEach(x -> System.out.println(x.toString()));
        System.out.println("==============================");
        
        StudentSubject studentSubject = fromJson(node1, StudentSubject.class);
        System.out.println(studentSubject);
    }
}
