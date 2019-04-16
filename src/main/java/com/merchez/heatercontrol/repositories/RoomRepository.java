package com.merchez.heatercontrol.repositories;

import com.merchez.heatercontrol.GenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.merchez.heatercontrol.beans.Room;


public interface RoomRepository extends GenericRepository<Room> {
	@Modifying
	@Query("UPDATE Room r SET r.name = ?1 WHERE r.id=?2")
	void update(String name, long id);
}
