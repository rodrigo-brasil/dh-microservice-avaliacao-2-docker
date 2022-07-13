package com.rodrigo.catalogservice.repository;

import com.rodrigo.catalogservice.model.Catalog;
import com.rodrigo.catalogservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, String> {
    Optional<Catalog> findByGenre(String genre);
}
