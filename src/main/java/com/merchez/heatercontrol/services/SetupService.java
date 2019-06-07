package com.merchez.heatercontrol.services;

import com.merchez.heatercontrol.beans.Setup;
import com.merchez.heatercontrol.repositories.SetupRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("setup")
public class SetupService implements ISetupService {
    private final SetupRepository repository;

    public SetupService(SetupRepository setupRepository){
        this.repository = setupRepository;
    }

    @Override
    public List<Setup> findAll() {
        return IteratorUtils.toList(this.repository.findAll().iterator());
    }

    @Override
    public Setup findById(long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Setup save(Setup entity) {
        return this.repository.save(entity);
    }
}
