package com.wcc.assessment.web.rest.vm;

import com.wcc.assessment.model.PostCode;

public class DistanceResponse {

    PostCode from_location;
    PostCode to_location;
    String distance;

    public PostCode getFrom_location() {
        return from_location;
    }

    public void setFrom_location(PostCode from_location) {
        this.from_location = from_location;
    }

    public PostCode getTo_location() {
        return to_location;
    }

    public void setTo_location(PostCode to_location) {
        this.to_location = to_location;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = String.format("%,.2f",distance).concat("km");
    }
}
