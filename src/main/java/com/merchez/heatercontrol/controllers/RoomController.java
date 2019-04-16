package com.merchez.heatercontrol.controllers;

import java.util.List;

import com.merchez.heatercontrol.services.RoomService;
import org.springframework.web.bind.annotation.*;

import com.merchez.heatercontrol.beans.Room;

@RestController
@RequestMapping("rooms")
public class RoomController {

	private RoomService roomService;

	public RoomController(RoomService roomService){
	    this.roomService = roomService;
    }

	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
    public List<Room> get_rooms() {
        return roomService.findAll();
    }
	
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Room get_room(@PathVariable(value="id") long id) {
        return roomService.findById(id);
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public Room post_room(@RequestParam("name") String name ) {
        Room entity = new Room(name);
    	return roomService.save(entity);
    }

    @RequestMapping(value={"/{id}"}, method=RequestMethod.PUT)
    public void put_room(@RequestParam("id") long id, @RequestParam("name") String name ) {
	    roomService.update(id, name);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete_room(@PathVariable(value="id") long id) {
    	roomService.deleteById(id);
    }
}
