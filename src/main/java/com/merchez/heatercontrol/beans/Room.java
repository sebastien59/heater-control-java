package com.merchez.heatercontrol.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="id")
    private Long id;
	
	@Column(name="name")
    private String name;
    
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy="room")
    private List<Sensor> sensors;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="room")
	private List<Plug> plugs;

	public Room(){
    }

    public Room(String name) {
    	this.name = name;
    	this.sensors = null;
    }
    
    public Room(Long id) {
    	this.id = id;
    	this.sensors = null;
    }
    
    public Room(Long id, String name){
        this.id = id;
        this.name = name;
        this.sensors = null;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public List<Sensor> getSensors(){
    	return this.sensors;
    }
    
    public List<Plug> getPlugs(){
    	return this.plugs;
    }
}
