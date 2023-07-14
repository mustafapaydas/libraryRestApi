package com.library.libraryApi.Entity.common;

import com.library.libraryApi.configuration.EnumAuthorization;
import com.library.libraryApi.core.AbstractEntity;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tbl_authorization_code")
public class AuthorizationCode extends AbstractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "authorization_code")
    private EnumAuthorization authorizationCode;
    @Column(name = "title")
    private String title;
    @ManyToMany
    @JoinTable(  name = "tbl_authorization_code_role_relation",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "code_id"))
    private List<Role> roles;


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
