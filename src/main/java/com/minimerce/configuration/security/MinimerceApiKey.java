package com.minimerce.configuration.security;

import com.minimerce.core.api.support.util.AES256Utils;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.security.access.AccessDeniedException;

/**
 * Created by gemini on 26/05/2017.
 */
@Getter
public class MinimerceApiKey {
    private static final String MINIMERCE_AES_KEY = "MinimerceIsGood!";
    private final long clientId;
    private final String apiKey;

    public MinimerceApiKey(String keyValue) {
        String rawApiKey = AES256Utils.decode(keyValue, MINIMERCE_AES_KEY);
        if(StringUtils.isEmpty(rawApiKey)) throw new AccessDeniedException("Invalid Api Key");
        if(StringUtils.containsNone(rawApiKey, ":")) throw new AccessDeniedException("Invalid Api Key");

        String[] clientSource = rawApiKey.split(":");
        if(clientSource.length < 2) throw new AccessDeniedException("Invalid Api Key");

        clientId = NumberUtils.toLong(clientSource[0], -1);
        apiKey = StringUtils.defaultString(clientSource[1], "");
        if(clientId == -1) throw new AccessDeniedException("Invalid Api Key");
        if(StringUtils.isEmpty(apiKey)) throw new AccessDeniedException("Invalid Api Key");
    }
}