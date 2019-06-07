package com.merchez.heatercontrol.controllers;

import com.merchez.heatercontrol.beans.Sensor;
import com.merchez.heatercontrol.beans.Setup;
import com.merchez.heatercontrol.services.SetupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("setups")
public class SetupController {
    private SetupService setupService;

    public SetupController(SetupService setupService ){
        this.setupService = setupService;
    }

    @RequestMapping(value={"/", ""}, method= RequestMethod.GET)
    public List<Setup> get_setups(){
        return this.setupService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Setup get_setup(@PathVariable(value="id") long id) {
        return setupService.findById(id);
    }

    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public Setup post_setup(@RequestParam("name") String name, @RequestParam("value") String value ) {
        Setup entity = new Setup(name, value);
        return setupService.save(entity);
    }

    @RequestMapping(value={"/{id}"}, method=RequestMethod.PUT)
    public void put_setup(@PathVariable("id") long id, @RequestParam("name") String name, @RequestParam("value") String value ) {
        Setup setup = new Setup(id, name, value);
        setupService.save(setup);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete_setup(@PathVariable(value="id") long id) {
        setupService.deleteById(id);
    }

}
