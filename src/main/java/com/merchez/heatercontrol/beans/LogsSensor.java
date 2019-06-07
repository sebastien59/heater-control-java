package com.merchez.heatercontrol.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="logs_sensor")
public class LogsSensor {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id")
    private Long id;
    @Column(name="date")
    @CreationTimestamp
    private LocalDateTime date;
    @Column(name="temperature")
    private Integer temperature;
    @Column(name="humidity")
    private Integer humidity;

    @JsonBackReference
    @JoinColumn(name="sensor", referencedColumnName="id")
    @ManyToOne
    private Sensor sensor;

    public LogsSensor(){
    }

    public LogsSensor(Integer temperature, Integer humidity, Sensor sensor){
        this.temperature = temperature;
        this.humidity = humidity;
        this.sensor = sensor;
    }

    public LogsSensor(Long id, Integer temperature, Integer humidity, Sensor sensor){
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.sensor = sensor;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
