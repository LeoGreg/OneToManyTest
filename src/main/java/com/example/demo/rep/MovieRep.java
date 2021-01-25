package com.example.demo.rep;

import com.example.demo.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRep extends CrudRepository<Movie, Long> {

    Movie save(Movie movie);

    Optional<Movie> findByIdAndTheatreId(Long id, Long theatre_id);
}
