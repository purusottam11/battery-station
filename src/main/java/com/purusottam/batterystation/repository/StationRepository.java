package com.purusottam.batterystation.repository;

import com.purusottam.batterystation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {

    Optional<Station> findById(Long id);
}
