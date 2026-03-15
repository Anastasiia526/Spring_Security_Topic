package org.example.homework.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "homeflowers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HomeFlower {
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
