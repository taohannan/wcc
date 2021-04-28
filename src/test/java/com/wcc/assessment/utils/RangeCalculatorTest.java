package com.wcc.assessment.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RangeCalculatorTest {

    @Test
    @DisplayName("To calculate distance between location")
    public void testDistance() {
         double fromLatitude = 57.144165 ;
         double fromLongtitude = -2.114848;
         double toLatitude = 57.124274;
         double toLonggtitude= -2.127190;
         double distance = RangeCalculator.calculateDistance(fromLatitude,fromLongtitude,toLatitude,toLonggtitude);
        System.out.println(distance);
        assertTrue(distance > 0);
    }
}
