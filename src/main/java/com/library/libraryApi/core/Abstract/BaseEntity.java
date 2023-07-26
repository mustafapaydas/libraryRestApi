package com.library.libraryApi.core.Abstract;

public interface BaseEntity<T> {
    T getId();
    void setId(T id);
}
