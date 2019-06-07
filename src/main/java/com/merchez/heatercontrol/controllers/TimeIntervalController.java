package com.merchez.heatercontrol.controllers;

import com.merchez.heatercontrol.beans.Room;
import com.merchez.heatercontrol.beans.TimeInterval;
import com.merchez.heatercontrol.services.RoomService;
import com.merchez.heatercontrol.services.TimeIntervalService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("time-intervals")
public class TimeIntervalController {
    private TimeIntervalService timeIntervalService;
    private RoomService roomService;

    public TimeIntervalController(TimeIntervalService timeIntervalService, RoomService roomService ){
        this.timeIntervalService = timeIntervalService;
        this.roomService = roomService;
    }

    @RequestMapping(value={"/", ""}, method= RequestMethod.GET)
    public List<TimeInterval> get_timeintervals(){
        return this.timeIntervalService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public TimeInterval get_timeintervals(@PathVariable(value="id") long id) {
        return timeIntervalService.findById(id);
    }

    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public TimeInterval post_setup(@RequestParam("startingTime") String startingTime, @RequestParam("endingTime") String endingTime,
                                   @RequestParam("dayNumber") Integer dayNumber, @RequestParam("room") Integer roomId) {
        LocalTime localStartingTime = LocalTime.parse(startingTime);
        LocalTime localEndingTime = LocalTime.parse(endingTime);

        Room room = roomService.findById(roomId);

        TimeInterval entity = new TimeInterval(localStartingTime, localEndingTime, dayNumber, room);
        return timeIntervalService.save(entity);
    }

    @RequestMapping(value={"/{id}"}, method=RequestMethod.PUT)
    public void put_setup(@PathVariable(value="id") long id, @RequestParam("startingTime") String startingTime, @RequestParam("endingTime") String endingTime,
                          @RequestParam("dayNumber") Integer dayNumber, @RequestParam("room") Integer roomId) {
        LocalTime localStartingTime = LocalTime.parse(startingTime);
        LocalTime localEndingTime = LocalTime.parse(endingTime);

        Room room = roomService.findById(roomId);

        TimeInterval entity = new TimeInterval(id, localStartingTime, localEndingTime, dayNumber, room);
        timeIntervalService.save(entity);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete_setup(@PathVariable(value="id") long id) {
        timeIntervalService.deleteById(id);
    }
}
