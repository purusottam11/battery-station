package com.purusottam.batterystation.service;

import com.purusottam.batterystation.dto.StationRequestDto;
import com.purusottam.batterystation.dto.StationResponseDto;

import java.util.List;


public interface StationService {
    List<StationResponseDto> getStations();

    StationResponseDto getStation(Long stationId);

    void createStation(StationRequestDto stationRequestDto);

    StationResponseDto updateStation(Long stationId, StationRequestDto stationRequestDto);

    void deleteStation(Long stationId);

    List<StationResponseDto> getStations(Integer limit);

    List<StationResponseDto> getStations(String sort, String column);
}
