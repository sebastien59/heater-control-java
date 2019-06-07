package com.merchez.heatercontrol.controllers;


import com.merchez.heatercontrol.beans.Sensor;
import com.merchez.heatercontrol.services.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sensors")
public class SensorController {
    private SensorService sensorService;

    public SensorController(SensorService sensorService ){
        this.sensorService = sensorService;
    }

    @RequestMapping(value={"/", ""}, method= RequestMethod.GET)
    public List<Sensor> get_sensors(){
        return this.sensorService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Sensor get_sensor(@PathVariable(value="id") long id) {
        return sensorService.findById(id);
    }

    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public Sensor post_sensor(@RequestParam("name") String name, @RequestParam("ip") String ip ) {
        Sensor entity = new Sensor(name, ip);
        return sensorService.save(entity);
    }

    @RequestMapping(value={"/{id}"}, method=RequestMethod.PUT)
    public void put_sensor(@PathVariable("id") long id, @RequestParam("name") String name, @RequestParam("ip") String ip ) {
        Sensor sensor = new Sensor(id, name, ip);
        sensorService.save(sensor);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete_sensor(@PathVariable(value="id") long id) {
        sensorService.deleteById(id);
    }
}
