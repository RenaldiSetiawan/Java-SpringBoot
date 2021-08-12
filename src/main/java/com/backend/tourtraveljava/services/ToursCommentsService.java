package com.backend.tourtraveljava.services;

import java.util.List;
import java.util.Optional;

import com.backend.tourtraveljava.model.ToursComments;

public interface ToursCommentsService {
    //Show list All Tours Comments
    List<ToursComments> findAllToursComments();

    //Insert Object Tours Comments ke db
    ToursComments addToursComments(ToursComments toursComments);

    //Find one ToursComments by Id
    Optional <ToursComments> findToursCommentsById(Long id);

    //Delete ToursComments by Id
    void deleteToursCommentsById(Long id);
}
