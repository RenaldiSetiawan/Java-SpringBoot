package com.backend.tourtraveljava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tours")
public class Tours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private Long tour_id;

    @Column(name = "tour_name", length = 100)
    @NotBlank(message = "nama Tour harus diisi!!")
    private String tour_name;

    @Column(name = "tour_route", length = 100)
    private String tour_route;

    @Column(name = "tour_package", length = 100)
    private String tour_package;

    @Column(name = "tour_schedule", length = 100)
    private Date tour_schedule;

    @Column(name = "tour_price", length = 100)
    @DecimalMin(value = "1500000.00", message = "Price must Higer than '${validateValue}'")
    @DecimalMax(value = "50000000.00", message = "Price not Greater than '${value}'")
    private Double tour_price;

    @Column(name = "tour_hotel", length = 100)
    private String tour_hotel;

    @Column(name = "tour_pesawat", length = 100)
    private String tour_pesawat;

    @Column(name = "tour_description", length = 100)
    private String tour_description;

    public Tours() {
    }

    public Tours(Long tour_id, @NotBlank(message = "nama Tour harus diisi!!") String tour_name, String tour_route,
            String tour_package, Date tour_schedule,
            @DecimalMin(value = "1500000.00", message = "Price must Higer than '${validateValue}'") @DecimalMax(value = "50000000.00", message = "Price not Greater than '${value}'") Double tour_price,
            String tour_hotel, String tour_pesawat, String tour_description) {
        this.tour_id = tour_id;
        this.tour_name = tour_name;
        this.tour_route = tour_route;
        this.tour_package = tour_package;
        this.tour_schedule = tour_schedule;
        this.tour_price = tour_price;
        this.tour_hotel = tour_hotel;
        this.tour_pesawat = tour_pesawat;
        this.tour_description = tour_description;
    }

    public Long getTour_id() {
        return tour_id;
    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public String getTour_name() {
        return tour_name;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public String getTour_route() {
        return tour_route;
    }

    public void setTour_route(String tour_route) {
        this.tour_route = tour_route;
    }

    public String getTour_package() {
        return tour_package;
    }

    public void setTour_package(String tour_package) {
        this.tour_package = tour_package;
    }

    public Date getTour_schedule() {
        return tour_schedule;
    }

    public void setTour_schedule(Date tour_schedule) {
        this.tour_schedule = tour_schedule;
    }

    public Double getTour_price() {
        return tour_price;
    }

    public void setTour_price(Double tour_price) {
        this.tour_price = tour_price;
    }

    public String getTour_hotel() {
        return tour_hotel;
    }

    public void setTour_hotel(String tour_hotel) {
        this.tour_hotel = tour_hotel;
    }

    public String getTour_pesawat() {
        return tour_pesawat;
    }

    public void setTour_pesawat(String tour_pesawat) {
        this.tour_pesawat = tour_pesawat;
    }

    public String getTour_description() {
        return tour_description;
    }

    public void setTour_description(String tour_description) {
        this.tour_description = tour_description;
    }

}
