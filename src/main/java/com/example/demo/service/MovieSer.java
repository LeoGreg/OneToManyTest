package com.example.demo.service;

import com.example.demo.model.Movie;
import javassist.NotFoundException;

import javax.transaction.Transactional;
import java.util.Map;

public interface MovieSer {
    @Transactional
    Movie add_movie(Movie movie, Long theatre_id) throws NotFoundException;

    @Transactional
    Movie update_movie(Long movie_id, Long theatre_id, Movie up_movie) throws NotFoundException;

    @Transactional
    Map<String, Boolean> deleteMovie(Long movieId, Long theatreId) throws NotFoundException;
}
