package com.library.libraryApi.DTO;

import com.library.libraryApi.core.Abstract.AbstractDTO;

public class CategoryDTO extends AbstractDTO<Integer> {
    private Integer id;
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
