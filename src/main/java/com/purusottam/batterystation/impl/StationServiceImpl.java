package com.purusottam.batterystation.impl;

import com.purusottam.batterystation.dto.StationRequestDto;
import com.purusottam.batterystation.dto.StationResponseDto;
import com.purusottam.batterystation.entity.Station;
import com.purusottam.batterystation.repository.StationRepository;
import com.purusottam.batterystation.service.StationService;
import com.purusottam.batterystation.utils.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;

    @Override
    public List<StationResponseDto> getStations() {
        List<Station> stations = stationRepository.findAll();
        return CopyUtils.copySafe(stations, StationResponseDto.class);
    }

    @Override
    public StationResponseDto getStation(Long stationId) {
        Station station = stationRepository.findById(stationId).orElseThrow(
                () -> new RuntimeException("Station not found : " + 404));
        return CopyUtils.copySafe(station, new StationResponseDto());
    }

    @Override
    public void createStation(StationRequestDto stationRequestDto) {
        Station station = CopyUtils.copySafe(stationRequestDto, new Station());
        station = stationRepository.save(station);
    }

    @Override
    public StationResponseDto updateStation(Long stationId, StationRequestDto stationRequestDto) {
        Station station = stationRepository.findById(stationId).orElseThrow(
                () -> new RuntimeException("Station not found : " + 404));
        CopyUtils.copySafe(stationRequestDto, station);
        station = stationRepository.save(station);
        return CopyUtils.copySafe(station, new StationResponseDto());
    }

    @Override
    public void deleteStation(Long stationId) {
        Station station = stationRepository.findById(stationId).orElseThrow(
                () -> new RuntimeException("Station not found : " + 404));
        stationRepository.deleteById(stationId);
    }

    @Override
    public List<StationResponseDto> getStations(Integer limit) {
        List<Station> stations = stationRepository.findAll(PageRequest.ofSize(limit)).toList();
        return CopyUtils.copySafe(stations, StationResponseDto.class);
    }

    @Override
    public List<StationResponseDto> getStations(String sort, String column) {
        List<Station> stations = new ArrayList<>();
        if (sort.equals("asc")) {
            stations = stationRepository.findAll(Sort.by(column).ascending());
        } else if (sort.equals("desc")) {
            stationRepository.findAll(Sort.by(column).descending());
        }
        return CopyUtils.copySafe(stations, StationResponseDto.class);
    }
}
