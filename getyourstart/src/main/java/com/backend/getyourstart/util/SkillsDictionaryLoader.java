package com.backend.getyourstart.util;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SkillsDictionaryLoader {
    public static Map<String, List<String>> loadSkills() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream in = new ClassPathResource("data/skills_dictionary.json").getInputStream()) {
            return mapper.readValue(in, new TypeReference<>() {});
        }
    }
}
