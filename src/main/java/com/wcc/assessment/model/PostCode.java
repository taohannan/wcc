package com.wcc.assessment.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "uk_postcode")
public class PostCode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
