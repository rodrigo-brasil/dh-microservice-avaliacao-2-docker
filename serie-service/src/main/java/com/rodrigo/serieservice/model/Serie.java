package com.rodrigo.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "series")
public class Serie {

    @Id
    private String id;
    private String name;
    private String genre;
    private Set<Season> seasons;

}
