package com.purusottam.batterystation.controller;

import com.purusottam.batterystation.dto.StationRequestDto;
import com.purusottam.batterystation.dto.StationResponseDto;
import com.purusottam.batterystation.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/")
    public ResponseEntity<List<StationResponseDto>> getStations() {
        return ResponseEntity.ok(stationService.getStations());
    }

    @GetMapping("/show/{stationId}")
    public ResponseEntity<StationResponseDto> getStation(@PathVariable Long stationId) {
        return ResponseEntity.ok(stationService.getStation(stationId));
    }

    @PostMapping("/")
    public void createStation(@RequestBody StationRequestDto stationRequestDto) {
        stationService.createStation(stationRequestDto);
    }

    @PutMapping("/edit/{stationId}")
    public ResponseEntity<StationResponseDto> getStation(@PathVariable Long stationId, @RequestBody StationRequestDto stationRequestDto) {
        return ResponseEntity.ok(stationService.updateStation(stationId, stationRequestDto));
    }

    @GetMapping("/delete/{stationId}")
    public void deleteStation(@PathVariable Long stationId) {
        stationService.deleteStation(stationId);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<StationResponseDto>> getStations(@RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(stationService.getStations(limit));
    }

    @GetMapping("/sort")
    public ResponseEntity<List<StationResponseDto>> getStations(@RequestParam("sort") String sort, @RequestParam("param") String param) {
        return ResponseEntity.ok(stationService.getStations(sort, param));
    }

}
