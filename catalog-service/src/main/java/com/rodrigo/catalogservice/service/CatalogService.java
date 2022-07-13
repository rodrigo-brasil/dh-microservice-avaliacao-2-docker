package com.rodrigo.catalogservice.service;

import com.rodrigo.catalogservice.model.Catalog;
import com.rodrigo.catalogservice.model.Movie;
import com.rodrigo.catalogservice.model.Serie;
import com.rodrigo.catalogservice.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

//    public List<Catalog> getCatalog(String genre) {
//        List<Movie> movieList = movieRepository.findAllByGenre(genre);
//    }

    public void saveMovieToCatalog(Movie movie) {
        String genre = movie.getGenre();
        Optional<Catalog> catalog = catalogRepository.findByGenre(genre);
        if (catalog.isPresent()) {
            Catalog catalogObj = catalog.get();
            catalogObj.getMovies().add(movie);
            catalogRepository.save(catalogObj);
        } else {
            Catalog newCatalog = new Catalog();
            newCatalog.setGenre(genre);
            newCatalog.setMovies(List.of(movie));
            catalogRepository.insert(newCatalog);
        }
    }

    public Catalog getCatalog(String genre) {
        return catalogRepository.findByGenre(genre).orElse(null);
    }

    public void saveSerieToCatalog(Serie serie) {
        String genre = serie.getGenre();
        Optional<Catalog> catalog = catalogRepository.findByGenre(genre);
        if (catalog.isPresent()) {
            Catalog catalogObj = catalog.get();
            catalogObj.getSeries().add(serie);
            catalogRepository.save(catalogObj);
        } else {
            Catalog newCatalog = new Catalog();
            newCatalog.setGenre(genre);
            newCatalog.setSeries(List.of(serie));
            catalogRepository.insert(newCatalog);
        }
    }
}
