package com.merchez.heatercontrol.services;

import com.merchez.heatercontrol.GenericRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import com.merchez.heatercontrol.beans.Room;
import com.merchez.heatercontrol.repositories.RoomRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("room")
public class RoomService implements IRoomService {
	private final RoomRepository repository;

	public RoomService(RoomRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Room> findAll(){
		return IteratorUtils.toList(this.repository.findAll().iterator());
	}

	@Override
	public Room findById(long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public void deleteById(long id){
		this.repository.deleteById(id);
	}

	@Override
	public Room save(Room entity) {
		return this.repository.save(entity);
	}
}
