package com.rodrigo.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Serie {

    private String id;
    private String name;
    private String genre;
    private Set<Season> seasons;

}
