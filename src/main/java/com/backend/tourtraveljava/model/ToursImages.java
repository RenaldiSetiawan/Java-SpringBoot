package com.backend.tourtraveljava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tours_images")
public class ToursImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toim_id")
    private Long toim_id;

    @Column(name = "toim_filename", length = 100)
    private String toim_filename;

    @Column(name = "toim_filesize", length = 100)
    private String toim_filesize;

    @Column(name = "toim_filetype", length = 50)
    private String toim_filetype;

    @Column(name = "toim_primary")
    private Boolean toim_primary;

    public ToursImages() {
    }

    public ToursImages(Long toim_id, String toim_filename, String toim_filesize, String toim_filetype,
            Boolean toim_primary) {
        this.toim_id = toim_id;
        this.toim_filename = toim_filename;
        this.toim_filesize = toim_filesize;
        this.toim_filetype = toim_filetype;
        this.toim_primary = toim_primary;
    }

    public Long getToim_id() {
        return toim_id;
    }

    public void setToim_id(Long toim_id) {
        this.toim_id = toim_id;
    }

    public String getToim_filename() {
        return toim_filename;
    }

    public void setToim_filename(String toim_filename) {
        this.toim_filename = toim_filename;
    }

    public String getToim_filesize() {
        return toim_filesize;
    }

    public void setToim_filesize(String toim_filesize) {
        this.toim_filesize = toim_filesize;
    }

    public String getToim_filetype() {
        return toim_filetype;
    }

    public void setToim_filetype(String toim_filetype) {
        this.toim_filetype = toim_filetype;
    }

    public Boolean getToim_primary() {
        return toim_primary;
    }

    public void setToim_primary(Boolean toim_primary) {
        this.toim_primary = toim_primary;
    }

    

}
