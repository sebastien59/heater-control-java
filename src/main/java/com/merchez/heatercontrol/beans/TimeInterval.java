package com.merchez.heatercontrol.beans;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="timeInterval")
public class TimeInterval {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="id")
    private Long id;
	@Column(name="startingTime", columnDefinition = "TIME")
    private LocalTime startingTime;
	@Column(name="endingTime", columnDefinition = "TIME")
    private LocalTime endingTime;
	@Column(name="dayNumber")
    private Integer dayNumber;
	@JoinColumn(name="room", referencedColumnName="id")
	@ManyToOne
    private Room room;

	public TimeInterval(){}

    public TimeInterval(long id, LocalTime startingTime, LocalTime endingTime, Integer dayNumber, Room room){
        this.id = id;
	    this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.dayNumber = dayNumber;
        this.room = room;
    }

    public TimeInterval(LocalTime startingTime, LocalTime endingTime, Integer dayNumber, Room room){
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.dayNumber = dayNumber;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalTime endingTime) {
        this.endingTime = endingTime;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
