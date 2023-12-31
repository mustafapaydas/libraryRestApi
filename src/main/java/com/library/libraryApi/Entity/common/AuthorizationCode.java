package com.library.libraryApi.Entity.common;

import com.library.libraryApi.core.Abstract.AbstractEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "tbl_authorization_code")
public class AuthorizationCode extends AbstractEntity<Integer> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "authorization_code")
    private String authorizationCode;
    @Column(name = "title")
    private String title;

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }



    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
