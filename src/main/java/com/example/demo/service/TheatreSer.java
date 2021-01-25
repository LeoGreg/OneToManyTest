package com.example.demo.service;

import com.example.demo.model.Theatre;
import javassist.NotFoundException;

import javax.transaction.Transactional;
import java.util.Map;

public interface TheatreSer {
    @Transactional
    Theatre add_theatre(Theatre theatre);

    @Transactional
    Theatre update_theatre(Theatre up_theatre, Long theatre_id) throws NotFoundException;

    @Transactional
    Map<String, Boolean> delete_theatre(Long theatre_id) throws NotFoundException;
}
