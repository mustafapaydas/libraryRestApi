package com.library.libraryApi.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.libraryApi.Entity.common.Role;


import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeycloakUser {
    @JsonProperty("sub")
    private String userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email_verified")
    private String verify;
    @JsonProperty("preferred_username")
    private String username;
    @JsonProperty("family_name")
    private String lastname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("groups")
    private List<String> roles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
