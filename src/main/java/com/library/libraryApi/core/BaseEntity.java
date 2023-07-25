package com.library.libraryApi.core;

public interface BaseEntity<T> {
    T getId();
    void setId(T id);
}
