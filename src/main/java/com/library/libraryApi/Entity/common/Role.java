package com.library.libraryApi.Entity.common;


import com.library.libraryApi.core.Abstract.AbstractEntity;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tbl_role")
public class Role extends AbstractEntity<Integer> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_role_authorization_code_relation",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "auth_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id", "auth_id"})})
    private List<AuthorizationCode> codes;

    public List<AuthorizationCode> getCodes() {
        return codes;
    }

    public void setCodes(List<AuthorizationCode> codes) {
        this.codes = codes;
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
