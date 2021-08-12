package com.backend.tourtraveljava.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.backend.tourtraveljava.model.ToursComments;
import com.backend.tourtraveljava.services.ToursCommentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tourscomments")
public class ToursCommentsController {
    @Autowired
    private ToursCommentsService toursCommentsService;

    //Find All ToursComments
    @GetMapping
    public ResponseEntity<?> findAllToursComments() {
        List<ToursComments> toco = toursCommentsService.findAllToursComments();
        return ResponseEntity.ok().body(toco);
    }

    //Create ToursComments
    @PostMapping("/add")
    public ResponseEntity<?> addToursComments (@RequestBody ToursComments toursComments) {
        try {
            ToursComments toco = toursCommentsService.addToursComments(toursComments);
            return ResponseEntity.ok().body(toco);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Find By Id
    @GetMapping("/findById")
    public ResponseEntity<?> findToursCommentsById (@PathParam("id") Long id) {
        Optional<ToursComments> toco = toursCommentsService.findToursCommentsById(id);

        if (!toco.isPresent()) {
            return ResponseEntity.badRequest().body("Data Not Found!!");
        }
        return ResponseEntity.ok().body(toco);
    }

    //Delete By Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteToursCommentsById (@PathVariable("id") Long id) {
        try {
            toursCommentsService.deleteToursCommentsById(id);
            return ResponseEntity.ok().body("ToursComments has been Delete!!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ToursComments Id not found");
        }
    }
}
