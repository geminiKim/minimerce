package com.minimerce.core.support.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimerce.configuration.MapperConfiguration;

/**
 * Created by gemini on 21/05/2017.
 */
public class Json {
    private static ObjectMapper getMapper() {
        return new MapperConfiguration().objectMapper();
    }

    public static <T> T fromJson(String jsonStr, Class<T> cls) {
        try {
            return getMapper().readValue(jsonStr, cls);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object object) {
        try {
            return getMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
