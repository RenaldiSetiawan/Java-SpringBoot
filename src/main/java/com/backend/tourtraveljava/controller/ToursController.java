package com.backend.tourtraveljava.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.backend.tourtraveljava.model.Tours;
import com.backend.tourtraveljava.services.ToursService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/tours")
public class ToursController {
    
    @Autowired
    private ToursService toursService;
    
    //FIND ALL 
    @GetMapping
    public ResponseEntity<?> findAllTours() {
        List<Tours> tours = toursService.findAllTours();
        return ResponseEntity.ok().body(tours);
    }

    //Create Tours
    @PostMapping("/add")
    public ResponseEntity<?> addTours (@RequestBody Tours tours) {
        try {
            Tours tour = toursService.addTours(tours);
            return ResponseEntity.ok().body(tour);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    

    //Edit
   /*  @PutMapping("/edit")
    public ResponseEntity<?> editTours (@RequestBody Tours tours) {
        try {
            Tours tour = toursService.editTours(tours);
            return ResponseEntity.ok().body(tour);
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    } */

    //FIND BY ID 
    @GetMapping("/findById")
    public ResponseEntity<?> findToursById (@PathParam("id") Long id) {
        Optional<Tours> tours = toursService.findToursById(id);

        if (!tours.isPresent()) {
            return ResponseEntity.badRequest().body("Data Not Found");
        }
        return ResponseEntity.ok().body(tours);
    }

    //Delete By id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteToursById(@PathVariable("id") Long id) {
        try {
            toursService.deleteToursById(id);
            return ResponseEntity.ok().body("Tours has been Deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Tours Id not Found");
        }
    }

}