package com.minimerce.core.builder;

import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.client.ClientRole;
import com.minimerce.core.support.util.Yn;

import java.time.LocalDateTime;

/**
 * Created by gemini on 22/06/2017.
 */
public final class ClientBuilder {
    protected Long id = 1L;
    protected LocalDateTime createdAt = LocalDateTime.now();
    protected LocalDateTime updatedAt = LocalDateTime.now();
    private String name = "test-client";
    private String corporation = "test-corporation";
    private String apiKey = "test-api-key";
    private ClientRole role = ClientRole.USER;
    private Yn deleted = Yn.N;

    private ClientBuilder() {
    }

    public static ClientBuilder aClient() {
        return new ClientBuilder();
    }

    public ClientBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientBuilder withCorporation(String corporation) {
        this.corporation = corporation;
        return this;
    }

    public ClientBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ClientBuilder withApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public ClientBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public ClientBuilder withRole(ClientRole role) {
        this.role = role;
        return this;
    }

    public ClientBuilder withDeleted(Yn deleted) {
        this.deleted = deleted;
        return this;
    }

    public Client build() {
        Client client = new Client();
        client.setName(name);
        client.setId(id);
        client.setCorporation(corporation);
        client.setCreatedAt(createdAt);
        client.setApiKey(apiKey);
        client.setUpdatedAt(updatedAt);
        client.setRole(role);
        client.setDeleted(deleted);
        return client;
    }
}
