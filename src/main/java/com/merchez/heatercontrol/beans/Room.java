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
import org.springframework.context.annotation.Primary;


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

    @JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy="room")
	private List<Plug> plugs;

    @Column(name="comfort_temperature")
    private Integer comfortTemperature;

    @Column(name="eco_temperature")
    private Integer ecoTemperature;


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

    public Integer getComfortTemperature() {
        return comfortTemperature;
    }

    public void setComfortTemperature(Integer comfortTemperature) {
        this.comfortTemperature = comfortTemperature;
    }

    public Integer getEcoTemperature() {
        return ecoTemperature;
    }

    public void setEcoTemperature(Integer ecoTemperature) {
        this.ecoTemperature = ecoTemperature;
    }

    public List<Sensor> getSensors(){
    	return this.sensors;
    }
    
    public List<Plug> getPlugs(){
    	return this.plugs;
    }


}
