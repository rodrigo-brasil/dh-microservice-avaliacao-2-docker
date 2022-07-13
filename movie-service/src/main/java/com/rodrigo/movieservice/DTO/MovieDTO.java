package com.rodrigo.movieservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO implements Serializable {

    private Long id;
    private String name;
    private String genre;
    private String urlStream;

}
