package com.tag;

import java.util.HashMap;
import java.util.Map;

// factory for tags
public class TagFactory {

    private static final Map<String, Tag> tagPool = new HashMap<>();

    public static Tag getTag(String name) {
        name = name.toLowerCase();
        if (!tagPool.containsKey(name)) {
            tagPool.put(name, new Tag(name));
        }

        return tagPool.get(name);
    }
}