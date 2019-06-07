package com.merchez.heatercontrol.controllers;


import com.merchez.heatercontrol.beans.LogsSensor;
import com.merchez.heatercontrol.beans.Sensor;
import com.merchez.heatercontrol.services.LogsSensorService;
import com.merchez.heatercontrol.services.SensorService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("processing")
public class ProcessingController {
    SensorService sensorService;
    LogsSensorService logsSensorService;

    public ProcessingController(SensorService sensorService, LogsSensorService logsSensorService){
        this.sensorService = sensorService;
        this.logsSensorService = logsSensorService;
    }

    @RequestMapping(value = "/sensor-data/{sensorId}", method= RequestMethod.POST)
    public void check_temperature(@PathVariable("sensorId") Long sensorId, @RequestParam("temperature") Integer temperature,
                                  @RequestParam("humidity") Integer humidity, @RequestParam("presence") Boolean presence){
        Sensor sensor = this.sensorService.findById(sensorId);

        LogsSensor logsSensor = new LogsSensor(temperature, humidity, sensor);

        // Logger les données
        this.logsSensorService.save(logsSensor);

        // Vérifier si la temperture est trop basse/trop haute
        if ( ((temperature < sensor.getRoom().getComfortTemperature() && presence) ||
             (temperature < sensor.getRoom().getEcoTemperature() && !presence))
        ) {
            sensor.getRoom().getPlugs().stream().forEach((plug) -> {

            });
            // Allumer les prises
        } else {
            // Eteindre
        }

        // Prédire la temperature et la présence dans X min

        System.out.println(temperature);
        System.out.println(humidity);
        System.out.println(presence);
    }
}
