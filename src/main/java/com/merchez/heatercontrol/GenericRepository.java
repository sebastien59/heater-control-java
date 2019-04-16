package com.merchez.heatercontrol;

import org.springframework.data.repository.CrudRepository;

public interface GenericRepository<T> extends CrudRepository<T, Long> {
}
