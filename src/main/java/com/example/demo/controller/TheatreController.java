package com.example.demo.controller;

import com.example.demo.model.Theatre;
import com.example.demo.service.TheatreSer;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/theatre")
public class TheatreController {

    @Autowired
    private TheatreSer theatreSer;


    @PostMapping("/add")
    public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) {
        return ResponseEntity.ok(theatreSer.add_theatre(theatre));
    }


    @PutMapping("/up{id}")
    public ResponseEntity<Theatre> update_theatre(@RequestBody Theatre theatre, @PathVariable(value = "id") Long theatre_id) throws NotFoundException {
        return ResponseEntity.ok(theatreSer.update_theatre(theatre, theatre_id));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Map<String, Boolean>> delete_theatre(@PathVariable(value = "id") Long theatre_id) throws NotFoundException {
        return ResponseEntity.ok(theatreSer.delete_theatre(theatre_id));
    }
}
