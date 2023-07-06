package com.library.libraryApi.core;

import java.util.List;

public interface ILogic<ENTITY> {
    ENTITY create(ENTITY entity);
    ENTITY update(ENTITY entity);
    ENTITY getById(Integer id);
    List<ENTITY> getByName(Integer id);
}
