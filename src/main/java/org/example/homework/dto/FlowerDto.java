package org.example.homework.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "homeflowers")
@Getter
@Setter
public class FlowerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "health_status")
    private String healthStatus;

    @Column(name="latin_name")
    private String latinName;

    private String name;
    private String room;
    private String type;

}
