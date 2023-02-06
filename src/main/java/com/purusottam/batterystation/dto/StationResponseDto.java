package com.purusottam.batterystation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationResponseDto {
    private String name;
    private String image;
    private Double pricing;
    private String address;
}
