package com.merchez.heatercontrol.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.context.annotation.Primary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Entity
@Table(name="sensor")
public class Sensor {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="id")
    private Long id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="ip")
    private String  ip;
	
	@JsonBackReference
	@JoinColumn(name="room", referencedColumnName="id")
	@ManyToOne
    private Room room;

	public Sensor(){}

    public Sensor(long id, String name, String ip){
	    this.id = id;
        this.name = name;
        this.ip = ip;
    }

	public Sensor(String name, String ip){
	    this.name = name;
	    this.ip = ip;
    }

    public Long getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name) throws BeanException{
    	if(name.length() > 20) {
    		throw new BeanException("Sensor name is to long. 20 characters maximum.");
    	}
        this.name=name;
    }
    
    public String getIp(){
        return this.ip;
    }
    
    public void setIp(String ip){
        this.ip = ip;
    }
    
    public Room getRoom(){
        return this.room;
    }
    
    public void setRoom(Room room){
        this.room = room;
    }

    public String getTemperature() throws IOException {
        BufferedReader in = null;
        String urlStringCont = "";

        URL url = new URL("http://" + this.getIp() + "/data");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String current;

        while ((current = in.readLine()) != null) {
            urlStringCont += current;
        }

        return urlStringCont;
    }
}
