package com.airportmanagementsystem.pilot_service.controller;

import com.airportmanagementsystem.pilot_service.dto.PilotDTO;
import com.airportmanagementsystem.pilot_service.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/pilot")
public class PilotController {

    @Autowired
    private PilotService pilotService;

    @GetMapping("/getPilots")
    public List<PilotDTO> getPilot() {
        return pilotService.getAllPilots();
    }

    @PostMapping("/savePilot")
    public PilotDTO savePilot(@RequestBody PilotDTO pilotDTO) {
        return pilotService.savePilot(pilotDTO);
    }

    @PutMapping("/updatePilot")
    public PilotDTO updatePilot(@RequestBody PilotDTO pilotDTO) {
        return pilotService.updatePilot(pilotDTO);
    }

    @DeleteMapping("/deletePilot")
    public boolean deletePilot(@RequestBody PilotDTO pilotDTO) {
        return pilotService.deletePilot(pilotDTO);
    }

    // pilot's details filter by using pilot_ID
    @GetMapping("/getPilotByPilotId/{pilotID}")
    public PilotDTO getPilotByPilotID(@PathVariable String pilotID) {
       return pilotService.getPilotById(pilotID);
    }

}
