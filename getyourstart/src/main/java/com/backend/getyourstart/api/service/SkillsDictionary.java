package com.backend.getyourstart.api.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service                                                // Marks this class as a Spring bean (singleton by default)
public class SkillsDictionary {

    // Raw JSON mapping as loaded from the file: canonical -> list of synonyms
    private final Map<String, List<String>> rawMap;

    // Lowercased, normalized view for case-insensitive lookups:
    // key = canonical (lowercase), value = set of lowercased synonyms (fast contains)
    private final Map<String, Set<String>> normalized;

    // Constructor runs at startup; loads and prepares the dictionary
    public SkillsDictionary() throws Exception {
        ObjectMapper mapper = new ObjectMapper();        // Jackson mapper instance

        // Try-with-resources: ensures InputStream is closed automatically
        try (InputStream in = new ClassPathResource("data/skills_dictionary.json").getInputStream()) {
            // Read JSON into Map<String, List<String>> using TypeReference (handles generics at runtime)
            rawMap = mapper.readValue(in, new TypeReference<Map<String, List<String>>>() {});
        }

        // Build the normalized, lowercase view for robust matching
        normalized = rawMap.entrySet().stream().collect(Collectors.toMap(
            e -> e.getKey().toLowerCase(),                                   // canonical in lowercase
            e -> e.getValue().stream().map(String::toLowerCase)              // synonyms in lowercase
                  .collect(Collectors.toSet())
        ));
    }

    /**
     * Quick membership test:
     * - returns true if the token is either a canonical skill or any synonym/alias
     */
    public boolean isSkillToken(String token) {
        if (token == null) return false;
        String t = token.toLowerCase();
        // Direct canonical hit?
        if (normalized.containsKey(t)) return true;
        // Check every synonyms set (values) for membership
        return normalized.values().stream().anyMatch(set -> set.contains(t));
    }

    /**
     * Returns the canonical skill for a given token/synonym.
     * e.g., "JS" -> "javascript"
     * If not recognized, returns null.
     */
    public String canonicalFor(String token) {
        if (token == null) return null;
        String t = token.toLowerCase();

        // If the token itself *is* a canonical
        if (normalized.containsKey(t)) return t;

        // Otherwise, find which canonical's synonym set contains it
        for (var entry : normalized.entrySet()) {
            if (entry.getValue().contains(t)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Returns all synonyms (original casing) for a canonical key, if you need them for UI.
     * If you pass a synonym by mistake, we canonicalize first.
     */

    /* 
        public List<String> getSynonyms(String maybeCanonical) {
            if (maybeCanonical == null) return List.of();
            String canonical = canonicalFor(maybeCanonical);
            if (canonical == null) {
                // Maybe it was already canonical but not lowercased
                canonical = maybeCanonical.toLowerCase();
                if (!normalized.containsKey(canonical)) return List.of();
            }
            // Find original key (case-sensitive) in rawMap to preserve original casing in the UI
            String originalKey = rawMap.keySet().stream()
                .filter(k -> k.equalsIgnoreCase(canonical))
                .findFirst().orElse(null);
            return originalKey == null ? List.of() : rawMap.get(originalKey);
        }
    */

    /**
     * Returns all canonical skills (lowercased).
     */
    public Set<String> allCanonicals() {
        return normalized.keySet();
    }
}