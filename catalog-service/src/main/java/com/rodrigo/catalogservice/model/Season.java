package com.rodrigo.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Season {

    private Long seasonNumber;
    private Set<Chapter> chapters;

}
