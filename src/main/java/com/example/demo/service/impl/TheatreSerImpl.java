package com.example.demo.service.impl;

import com.example.demo.model.Theatre;
import com.example.demo.rep.TheatreRep;
import com.example.demo.service.TheatreSer;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
public class TheatreSerImpl implements TheatreSer {

    @Autowired
    private TheatreRep theatreRep;


    @Override
    @Transactional
    public Theatre add_theatre(Theatre theatre) {
        return theatreRep.save(theatre);
    }


    @Override
    @Transactional
    public Theatre update_theatre(Theatre up_theatre, Long theatre_id) throws NotFoundException {
        Theatre db_theatre = theatreRep.findById(theatre_id).orElseThrow(() -> new NotFoundException("not,found::" + theatre_id));
        db_theatre.setName(up_theatre.getName());
        return theatreRep.save(db_theatre);
    }

    @Override
    @Transactional
    public Map<String, Boolean> delete_theatre(Long theatre_id) throws NotFoundException {
        Theatre db_theatre = theatreRep.findById(theatre_id).orElseThrow(() -> new NotFoundException("theatre.not.found:: " + theatre_id));
        theatreRep.delete(db_theatre);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
