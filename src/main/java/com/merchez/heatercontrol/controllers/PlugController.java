package com.merchez.heatercontrol.controllers;

import com.merchez.heatercontrol.beans.Plug;
import com.merchez.heatercontrol.services.PlugService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("plugs")
public class PlugController {
    private PlugService plugService;

    public PlugController(PlugService plugService ){
        this.plugService = plugService;
    }

    @RequestMapping(value={"/", ""}, method= RequestMethod.GET)
    public List<Plug> get_plugs(){
        return plugService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Plug get_plug(@PathVariable(value="id") long id) {
        return plugService.findById(id);
    }

    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public Plug post_plug(@RequestParam("name") String name, @RequestParam("ip") String ip,
                          @RequestParam(value = "state", required = false) boolean state,
                          @RequestParam(value = "forced", required = false) boolean forced ) {
        Plug entity = new Plug(name, ip);
        if (state){
            entity.setState(state);
        }else{
            entity.setState(false);
        }

        if (forced){
            entity.setForced(forced);
        }else{
            entity.setForced(false);
        }

        return plugService.save(entity);
    }

    @RequestMapping(value={"/{id}"}, method=RequestMethod.PUT)
    public void put_plug(@PathVariable("id") long id, @RequestParam("name") String name, @RequestParam("ip") String ip,
                           @RequestParam(value = "state", required = false) boolean state,
                           @RequestParam(value = "forced", required = false) boolean forced) {
        Plug entity = new Plug(id, name, ip);
        if (state){
            entity.setState(state);
        }else{
            entity.setState(false);
        }

        if (forced){
            entity.setForced(forced);
        }else{
            entity.setForced(false);
        }

        plugService.save(entity);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete_plug(@PathVariable(value="id") long id) {
        plugService.deleteById(id);
    }
}
