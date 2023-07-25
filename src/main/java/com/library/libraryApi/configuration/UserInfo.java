package com.library.libraryApi.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;

public class UserInfo {

    private String userId;

    private String name;

    private String verify;

    private String username;

    private String lastname;

    private String email;

    private List<String> roles;
    private List<String> authorities;

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public UserInfo() {

    }

    public UserInfo(String userId, String name, String verify, String username, String lastname, String email, List<String> roles) {
        this.userId = userId;
        this.name = name;
        this.verify = verify;
        this.username = username;
        this.lastname = lastname;
        this.email = email;
        this.roles = roles;
    }

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
