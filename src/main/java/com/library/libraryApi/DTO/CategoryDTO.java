package com.library.libraryApi.DTO;

import com.library.libraryApi.core.AbstractDTO;

public class CategoryDTO extends AbstractDTO<Integer> {
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

 }
