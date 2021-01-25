package com.example.demo.rep;

import com.example.demo.model.Theatre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRep extends CrudRepository<Theatre, Long> {

    Theatre save(Theatre theatre);


}
