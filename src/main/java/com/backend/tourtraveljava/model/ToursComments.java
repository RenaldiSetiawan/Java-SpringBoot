package com.backend.tourtraveljava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tours_comments")
public class ToursComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toco_id")
    private Long toco_id;

    @Column(name = "toco_comments", length = 255)
    @NotBlank(message = "Komentar Harus diisi!!")
    private String toco_comments;

    @Column(name = "toco_created_on")
    private Date toco_created_on;

    @Column(name = "toco_rating", length = 5)
    private Float toco_rating;

    public ToursComments() {
    }

    

    public ToursComments(Long toco_id, @NotBlank(message = "Komentar Harus diisi!!") String toco_comments,
            Date toco_created_on, Float toco_rating) {
        this.toco_id = toco_id;
        this.toco_comments = toco_comments;
        this.toco_created_on = toco_created_on;
        this.toco_rating = toco_rating;
    }



    public Long getToco_id() {
        return toco_id;
    }

    public void setToco_id(Long toco_id) {
        this.toco_id = toco_id;
    }

    public String getToco_comments() {
        return toco_comments;
    }

    public void setToco_comments(String toco_comments) {
        this.toco_comments = toco_comments;
    }

    public Date getToco_created_on() {
        return toco_created_on;
    }

    public void setToco_created_on(Date toco_created_on) {
        this.toco_created_on = toco_created_on;
    }

    public Number getToco_rating() {
        return toco_rating;
    }

    public void setToco_rating(Float toco_rating) {
        this.toco_rating = toco_rating;
    }

   
    
}
