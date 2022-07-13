package com.rodrigo.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "catalogs")
public class Catalog {

    @Id
    private String genre;

    private List<Movie> movies = new ArrayList<>();
    private List<Serie> series = new ArrayList<>();
}
