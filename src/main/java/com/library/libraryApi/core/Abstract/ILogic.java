package com.library.libraryApi.core.Abstract;

import java.util.List;

public interface ILogic<ENTITY,ID> {
    ENTITY create(ENTITY entity);
    ENTITY update(ENTITY entity);
    ENTITY findById(ID id);
}
