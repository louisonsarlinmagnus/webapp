package com.boot.service;

import java.util.List;

public interface CRUDService<T> {
    List<T> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}