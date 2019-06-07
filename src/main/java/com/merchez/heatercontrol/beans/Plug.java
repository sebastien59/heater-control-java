package com.merchez.heatercontrol.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Entity
@Table(name="plug")
public class Plug {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="id")
    private Long id;
	@Column(name="name")
    private String name;
	@Column(name="ip")
    private String ip;
	@Column(name="state")
    private Boolean state;

	@JsonBackReference
	@JoinColumn(name="room", referencedColumnName="id")
	@ManyToOne
	private Room room;
	
	@Column(name="forced")
    private Boolean forced;

	public Plug(){}

    public Plug(long id, String name, String ip) {
	    this.id = id;
        this.name = name;
        this.ip = ip;
    }

	public Plug(String name, String ip, boolean state, boolean forced){
	    this.name = name;
	    this.ip = ip;
	    this.state = state;
	    this.forced = forced;
    }

    public Plug(String name, String ip) {
	    this.name = name;
	    this.ip = ip;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Boolean getForced() {
        return forced;
    }

    public void setForced(Boolean forced) {
        this.forced = forced;
    }

    public String switchOnOff(boolean state) throws IOException {
        BufferedReader in = null;
        String urlStringCont = "";

        URL url = new URL("http://" + this.getIp() + "/");
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
