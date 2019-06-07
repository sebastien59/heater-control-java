package com.merchez.heatercontrol.services;

import com.merchez.heatercontrol.beans.TimeInterval;
import com.merchez.heatercontrol.repositories.TimeIntervalRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("timeinterval")
public class TimeIntervalService implements ITimeIntervalService{
    private final TimeIntervalRepository repository;

    public TimeIntervalService(TimeIntervalRepository timeIntervalRepository){
        this.repository = timeIntervalRepository;
    }

    @Override
    public List<TimeInterval> findAll() {
        return IteratorUtils.toList(this.repository.findAll().iterator());
    }

    @Override
    public TimeInterval findById(long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public TimeInterval save(TimeInterval entity) {
        return this.repository.save(entity);
    }
}
