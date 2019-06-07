package com.merchez.heatercontrol.services;

import com.merchez.heatercontrol.beans.Sensor;
import com.merchez.heatercontrol.repositories.SensorRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sensor")
public class SensorService implements ISensorService {
    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sensor> findAll(){
        return IteratorUtils.toList(this.repository.findAll().iterator());
    }

    @Override
    public Sensor findById(long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public void deleteById(long id){
        this.repository.deleteById(id);
    }

    @Override
    public Sensor save(Sensor entity) {
        return this.repository.save(entity);
    }

}
