package com.merchez.heatercontrol.services;

import com.merchez.heatercontrol.beans.LogsSensor;
import com.merchez.heatercontrol.repositories.LogsSensorRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logsService")
public class LogsSensorService implements ILogsSensorService {
    LogsSensorRepository repository;

    public LogsSensorService(LogsSensorRepository repository){
        this.repository = repository;
    }

    @Override
    public List<LogsSensor> findAll() {
        return IteratorUtils.toList(repository.findAll().iterator());
    }

    @Override
    public LogsSensor findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public LogsSensor save(LogsSensor entity) {
        return repository.save(entity);
    }
}
