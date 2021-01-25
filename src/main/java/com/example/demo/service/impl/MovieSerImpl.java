package com.example.demo.service.impl;

import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;
import com.example.demo.rep.MovieRep;
import com.example.demo.rep.TheatreRep;
import com.example.demo.service.MovieSer;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MovieSerImpl implements MovieSer {

    @Autowired
    private MovieRep movieRep;
    @Autowired
    private TheatreRep theatreRep;


    @Override
    @Transactional
    public Movie add_movie(Movie movie, Long theatre_id) throws NotFoundException {
        return theatreRep.findById(theatre_id).map(theatre -> {
            movie.setTheatre(theatre);
            return movieRep.save(movie);
        }).orElseThrow(() -> new NotFoundException("movie.not.found"));
    }


    @Override
    @Transactional
    public Movie update_movie(Long movie_id, Long theatre_id, Movie up_movie) throws NotFoundException {
        if (!theatreRep.findById(theatre_id).isPresent()) {
            throw new NotFoundException("not.found.theatre");
        }
        return movieRep.findById(movie_id).map(db_movie -> {
            db_movie.setName(up_movie.getName());
            return movieRep.save(db_movie);
        }).orElseThrow(() -> new NotFoundException("movie.not.found"));
    }


    @Override
    @Transactional
    public Map<String, Boolean> deleteMovie(Long movieId, Long theatreId) throws NotFoundException {
        return movieRep.findByIdAndTheatreId(movieId, theatreId).map(db_movie -> {
            movieRep.delete(db_movie);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }).orElseThrow(() -> new NotFoundException("not.found " + "movie_id : " + movieId + " " + " theatre_id : " + theatreId));
    }
}
