package com.minimerce.configuration.security;

import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.client.ClientRepository;
import com.minimerce.core.support.util.ApiKeyEncryptUtils;
import org.springframework.security.access.AccessDeniedException;
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

    public Client auth(String keyValue) {
        Client client = clientRepository.findByApiKey(ApiKeyEncryptUtils.decode(keyValue));
        if(null == client) throw new AccessDeniedException("Invalid Api Key");
        return client;
    }
}
