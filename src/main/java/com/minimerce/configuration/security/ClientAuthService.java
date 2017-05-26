package com.minimerce.configuration.security;

import com.minimerce.core.api.domain.client.Client;
import com.minimerce.core.api.domain.client.ClientRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by gemini on 26/05/2017.
 */
@Service
public class ClientAuthService {
    private final ClientRepository clientRepository;

    @Inject
    public ClientAuthService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client auth(String apiKey) {
        if(StringUtils.isEmpty(apiKey)) throw new BadCredentialsException("Bad Request");
        Client client = clientRepository.findByApiKey(apiKey);
        if(null == client) throw new BadCredentialsException("Invalid Client");
        return client;

    }
}
