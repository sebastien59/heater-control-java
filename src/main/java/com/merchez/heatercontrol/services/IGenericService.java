package com.merchez.heatercontrol.services;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();
    T findById(long id);
    void deleteById(long id);
    T save(T entity);
}
