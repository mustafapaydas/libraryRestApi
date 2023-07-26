package com.library.libraryApi.configuration;



import com.library.libraryApi.Entity.common.AuthorizationCode;
import com.library.libraryApi.Entity.common.Role;
import com.library.libraryApi.Repository.common.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Value("${role-attribute}")
    private String role;
    private JwtAuthenticationConverter jwtAuthenticationConverter;
    private JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter;
    private final JwtAuthConverterProperties properties;
    @Autowired
    RoleRepository roleRepository;
    @Autowired AuthenticationLogic authenticationLogic;

    public JwtAuthConverter(JwtAuthConverterProperties properties) {
        this.jwtAuthenticationConverter = new JwtAuthenticationConverter();
        this.jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        this.properties = properties;
    }

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<SimpleGrantedAuthority> auths = extractResourceRoles(jwt);
        setUserInfo(jwt,auths);
        return new JwtAuthenticationToken(jwt, auths, getPrincipalClaimName(jwt));
    }
    private void setUserInfo(Jwt jwt,Collection<SimpleGrantedAuthority> auths){
        UserInfo user = new UserInfo();
        user.setUserId(jwt.getClaims().get("sub").toString());
        user.setEmail(jwt.getClaims().get("email").toString());
        user.setName(jwt.getClaims().get("name").toString());
        user.setLastname(jwt.getClaims().get("family_name").toString());
        user.setRoles(Arrays.asList(jwt.getClaims().get(role)).stream().map(r->r.toString()).collect(Collectors.toList()));
        user.setAuthorities(new ArrayList<>(auths.stream().map(a->a.toString()).collect(Collectors.toList())));
        authenticationLogic.setCurrentUser(user);
    }

    private String getPrincipalClaimName(Jwt jwt) {
        String claimName = JwtClaimNames.SUB;
        if (properties.getPrincipalAttribute() != null) {
            claimName = properties.getPrincipalAttribute();
        }
        return jwt.getClaim(claimName);
    }

    private Collection<SimpleGrantedAuthority> extractResourceRoles(Jwt jwt) {
        List<String> resourceAccess = jwt.getClaim("groups");


        Set<String> roles = resourceAccess.stream()
                .map(role -> (role.replace("/","")))
                .collect(Collectors.toSet());
        List<Role> dbRole = roleRepository.getRolesByTitles(roles);

        HashSet<AuthorizationCode> authorizationCodes = new HashSet<>();
        dbRole.stream().forEach(r->r.getCodes().forEach(c->authorizationCodes.add(c)));
        List<SimpleGrantedAuthority> authorityList =
                authorizationCodes.stream()
                        .map(AuthorizationCode::getAuthorizationCode)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        return authorityList;

    }

}
