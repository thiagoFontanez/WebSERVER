package com.testDistance.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceTest {

    @Test
    public void GivenACityPairWhenGetDistanceValueInKilometersThenReturnsCorrectResultInKilometers(){
        City newYork = new City(1, "New York", 40.730610, -73.935242);
        City saoPaulo = new City(2, "São Paulo", -23.533773, -46.625290);

        Distance distance = new Distance(newYork, saoPaulo, MeasureUnit.KILOMETERS);

        double exactDistanceBetweenNYAndSPInKilometers = 7679.79;
        double error = exactDistanceBetweenNYAndSPInKilometers * 0.05;

        assertEquals(distance.getDistanceValue(), exactDistanceBetweenNYAndSPInKilometers, error);
    }

    @Test
    public void GivenACityPairWhenGetDistanceValueInMilesThenReturnsCorrectResultInMiles(){
        City campinas = new City(1, "Campinas", -22.907104, -47.063240);
        City saoPaulo = new City(2, "São Paulo", -23.533773, -46.625290);

        Distance distance = new Distance(campinas, saoPaulo, MeasureUnit.MILES);

        double exactDistanceBetweenCAAndSPInMiles = 51.89;
        double error = exactDistanceBetweenCAAndSPInMiles * 0.05;

        assertEquals(distance.getDistanceValue(), exactDistanceBetweenCAAndSPInMiles, error);
    }
}