package com.example.demo.controller;


import com.example.demo.model.Movie;
import com.example.demo.service.MovieSer;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieSer movieSer;


    @PostMapping("/add/{theatre_id}")//we need thatre_id to find by id in service and set to movie
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie, @PathVariable Long theatre_id) throws NotFoundException {
        return ResponseEntity.ok(movieSer.add_movie(movie, theatre_id));
    }


    @PutMapping("/movie/{movie_id}/theatre/{theatre_id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "movie_id") Long movieId, @PathVariable(value = "theatre_id") Long theatreId, @RequestBody Movie up_movie) throws NotFoundException {
        return ResponseEntity.ok(movieSer.update_movie(movieId, theatreId, up_movie));
    }

    @DeleteMapping("/del/{movie_id}/theatre/{theatre_id}")
    public ResponseEntity<Map<String, Boolean>> deleteMovie(@PathVariable(value = "movie_id") Long movieId, @PathVariable(value = "theatre_id") Long theatreId) throws NotFoundException {
        return ResponseEntity.ok(movieSer.deleteMovie(movieId, theatreId));
    }
}
