package com.library.libraryApi.Logic.common;

import com.library.libraryApi.Entity.common.AuthorizationCode;
import com.library.libraryApi.Repository.common.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizationLogic{
    @Autowired
    AuthorizationRepository _repository;
    public List<String> getAuthorizationList(List<String> groups){
        return _repository.getAuthorizationCodesByRoles(groups);
    }

}
