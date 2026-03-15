package org.example.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlowerDto {

    private int id;

    private String healthStatus;

    private String latinName;

    private String name;
    private String room;
    private String type;

}
