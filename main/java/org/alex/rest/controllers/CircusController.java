package org.alex.rest.controllers;

import org.alex.rest.exception.circus.not.found.CircusNotFoundException;
import org.alex.rest.models.Circus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.alex.rest.service.CircusService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/circus")

public class CircusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CircusController.class);

    @Autowired
    private CircusService circusService;

    @PostMapping
    public ResponseEntity<Circus> createCircus(@Valid @RequestBody final Circus circus) {
        LOGGER.info("Added new circus");
        return new ResponseEntity<Circus>(circusService.addCircus(circus), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Circus> updateCircus(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Circus circus) {

        if (circusService.getCircusById(id) == null) {
            LOGGER.error("Can't put(updateCircus) an circus with non-existing id: " + id);
            throw new CircusNotFoundException("Can't put(updateCircus) an circus with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated circus with id: " + id);
        circus.setId(id);
        return new ResponseEntity<Circus>(circusService.updateCircus(circus), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Circus>> getCircuses() {
        LOGGER.info("Gave away all Circuses");
        return new ResponseEntity<List<Circus>>(circusService.getCircus(), HttpStatus.OK);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<Circus>> getCircusFilter(@RequestParam(required = false,value = "name") final String name) {
        List<Circus> circus = circusService.getCircus();
        System.out.println(circus.get(0).getName().matches(name));
        List<Circus> circusFilter = circus.stream().filter(f -> f.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

        if (circusFilter.isEmpty()) {
            LOGGER.error("there is no such circuses " + name);
            throw new CircusNotFoundException("there is no such circuses " + name);
        }
        LOGGER.info("Successfully found such circuses " + name);
        return new ResponseEntity<List<Circus>>(circusFilter, HttpStatus.OK);
    }

    @GetMapping(path = "/sort")
    public ResponseEntity<List<Circus>> getCircusSort(@RequestParam(required = false,value = "name") final String name) {
        List<Circus> circus = circusService.getCircus();
        if(name.equals("amountOfPlaces")){
            circus.sort((Circus f1,Circus f2)->Double.compare(f1.getAmountOfPlaces(),f2.getAmountOfPlaces()));
        }else if(name.equals("amountOfPerformances")){
            circus.sort((Circus f1,Circus f2)->Double.compare(f1.getPerformancesPerYear(),f2.getPerformancesPerYear()));
        }
        LOGGER.info("Successfully found such circuses" + name);
        return new ResponseEntity<List<Circus>>(circus, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Circus> getCircus(@PathVariable(name = "id") final Integer id) {
        if (circusService.getCircusById(id) == null) {
            LOGGER.error("Can't get(getCircus) an circus with non-existing id: " + id);
            throw new CircusNotFoundException("Can't get(getCircus) an circus with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an circus with id: " + id);
        return new ResponseEntity<Circus>(circusService.getCircusById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Circus> deleteCircusById(@PathVariable("id") final Integer id) {
        if (circusService.getCircusById(id) == null) {
            LOGGER.error("Can't delete(deleteCircusById) an circus with non-existing id: " + id);
            throw new CircusNotFoundException("Can't delete(deleteCircusById) an circus with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted circus with id: " + id);
        circusService.deleteCircusById(id);
        return ResponseEntity.noContent().build();
    }

}
