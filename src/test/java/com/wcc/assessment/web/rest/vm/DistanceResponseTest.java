package com.wcc.assessment.web.rest.vm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceResponseTest {

    @Test
    @DisplayName("To display unit in KM")
    public void setDistance_Test() {

        DistanceResponse response = new DistanceResponse();
        double distance = 2.333797535167495;
        response.setDistance(distance);
        assertEquals("2.33km",response.getDistance());

    }
}
