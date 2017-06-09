package com.minimerce.configuration.security;

import com.google.common.collect.Lists;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.client.ClientRole;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gemini on 11/05/2017.
 */
@Service
public class AuthenticationService {
    @Inject private ClientAuthService clientAuthService;

    public void authentication(HttpServletRequest request) {
        Client client = clientAuthService.auth(request.getHeader("minimerce-api-key"));
        Authentication authentication = new UsernamePasswordAuthenticationToken(client, null, buildAuthorities(client.getRole()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public List<GrantedAuthority> buildAuthorities(ClientRole role) {
        if(ClientRole.ADMIN == role) return Lists.newArrayList((GrantedAuthority) () -> ClientRole.ADMIN.name());
        else return Lists.newArrayList((GrantedAuthority) () -> ClientRole.USER.name());
    }
}
