package com.merchez.heatercontrol.services;

import java.util.List;
import org.apache.commons.collections4.IteratorUtils;
import com.merchez.heatercontrol.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class GenericService<T> implements IGenericService<T> {
	@Autowired
	private GenericRepository<T> repository;

	public GenericService() {
	}

	@Override
	public List<T> findAll(){
		return IteratorUtils.toList(this.repository.findAll().iterator());
	}

	@Override
	public T findById(long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public void deleteById(long id){
		this.repository.deleteById(id);
	}

	@Override
	public T save(T entity) {
		return this.repository.save(entity);
	}
}
