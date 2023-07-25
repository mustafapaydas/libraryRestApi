package com.library.libraryApi.configuration;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationLogic {
    private UserInfo currentUser;

    public UserInfo getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserInfo currentUser) {

        this.currentUser = currentUser;
    }

    public String getCurrentUserId(){
        if (SecurityContextHolder.getContext().getAuthentication() != null)
            return SecurityContextHolder.getContext().getAuthentication().getName();
        return null;
    }
}
