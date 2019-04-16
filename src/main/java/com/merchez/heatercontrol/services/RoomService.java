package com.merchez.heatercontrol.services;

import org.springframework.stereotype.Service;

import com.merchez.heatercontrol.beans.Room;
import com.merchez.heatercontrol.repositories.RoomRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService extends GenericService<Room> implements IRoomService {
	private final RoomRepository roomRepository;

	public RoomService(RoomRepository roomRepository) {
		super(roomRepository);
		this.roomRepository = roomRepository;
	}

	@Override
	@Transactional
	public void update(long id, String name) {
		this.roomRepository.update(name, id);
	}
}
