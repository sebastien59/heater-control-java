package com.merchez.heatercontrol.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="setup")
public class Setup {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id")
    private Long id;
	@Column(name="name")
    private String name;
	@Column(name="value")
    private String value;

	public Setup(){}

    public Setup(Long id, String name, String value){
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Setup(String name, String value){
        this.name = name;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
