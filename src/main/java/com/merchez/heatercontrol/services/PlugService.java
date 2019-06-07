package com.merchez.heatercontrol.services;

import com.merchez.heatercontrol.beans.Plug;
import com.merchez.heatercontrol.repositories.PlugRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("plug")
public class PlugService implements IPlugService {
    public final PlugRepository repository;

    public PlugService(PlugRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Plug> findAll() {
        return IteratorUtils.toList(repository.findAll().iterator());
    }

    @Override
    public Plug findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Plug save(Plug entity) {
        return repository.save(entity);
    }
}
