package com.backend.tourtraveljava.services;

import java.util.List;
import java.util.Optional;

import com.backend.tourtraveljava.model.ToursImages;

public interface ToursImagesService {
    //Show list all tours imaes
    List<ToursImages> findAllToursImages();

    //Insert Object tours images ke db
    ToursImages addToursImages(ToursImages toursImages);

    //find by id
    Optional <ToursImages> findToursImagesById(Long id);

    //delet by id
    void deleteToursImagesById(Long id);
}
