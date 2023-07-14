package com.library.libraryApi.Entity.common;


import com.library.libraryApi.core.AbstractEntity;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tbl_role")
public class Role extends AbstractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<AuthorizationCode> codes;

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
