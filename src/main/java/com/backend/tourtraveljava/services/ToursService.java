package com.backend.tourtraveljava.services;

import java.util.List;
import java.util.Optional;

import com.backend.tourtraveljava.model.Tours;

public interface ToursService {
    //Show list All Tours
    List<Tours> findAllTours();

    //Insert Object Tours ke db
    Tours addTours(Tours tours);

    //Edit Object
    Tours editTours(Tours tours);

    //Cari data Tours Sesuai Id
    Optional<Tours> findToursById(Long id);

    //Delete Tours sesuai Id yang dikirim
    void deleteToursById(Long id);
}
