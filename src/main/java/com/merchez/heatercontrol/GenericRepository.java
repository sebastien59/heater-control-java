package com.merchez.heatercontrol;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository<T> extends CrudRepository<T, Long> {
}
