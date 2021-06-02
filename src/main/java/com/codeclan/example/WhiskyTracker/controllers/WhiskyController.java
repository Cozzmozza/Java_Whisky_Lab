package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "distilleryId", required = false) Long distilleryId, // Could do name instead?
            @RequestParam(name = "region", required = false) String region
    ){
        if (year != null){
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        if (distilleryId != null && age != null){
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findByAgeAndDistilleryId(age, distilleryId), HttpStatus.OK);
        }
        if (region != null){
//            Changing first letter of string to uppercase, to match DataLoader entries
            String fixedRegion = region.substring(0, 1).toUpperCase() + region.substring(1);
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findByDistilleryRegion(fixedRegion), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getWhisky(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping (value = "/whiskies")
    public ResponseEntity<Whisky> postWhisky(@RequestBody Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }
}
