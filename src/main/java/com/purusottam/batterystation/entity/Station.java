package com.purusottam.batterystation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "station_tb")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_id")
    private Long id;
    @Column(name = "station_name")
    private String name;
    @Column(name = "station_image")
    private String image;
    @Column(name = "station_pricing")
    private Double pricing;
    @Column(name = "station_address")
    private String address;


}
