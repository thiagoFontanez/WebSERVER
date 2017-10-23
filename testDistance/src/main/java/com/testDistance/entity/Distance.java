package com.testDistance.entity;

public class Distance {

    private static final int EARTH_RADIUS = 6371;
    private final MeasureUnit measureUnit;

    private City cityOne = new City();
    private City cityTwo = new City();

    public Distance(City cityOne, City cityTwo, MeasureUnit measureUnit){
        this.cityOne = cityOne;
        this.cityTwo = cityTwo;
        this.measureUnit = measureUnit;
    }

    public City getCityOne() {
        return cityOne;
    }

    public void setCityOne(City cityOne) {
        this.cityOne = cityOne;
    }

    public City getCityTwo() {
        return cityTwo;
    }

    public void setCityTwo(City cityTwo) {
        this.cityTwo = cityTwo;
    }

    public MeasureUnit getMeasureUnit() {
    	return measureUnit;
    }
    
    public double getDistanceValue() {
    	return getDistanceValueInKilometers() * measureUnit.conversionFactor();
    }
    
    private double getDistanceValueInKilometers() {

        double radianLatitudeDistance = degreesToRadians(cityTwo.getLatitude() - cityOne.getLatitude());
        double radianLongitudeDistance = degreesToRadians(cityTwo.getLongitude() - cityOne.getLongitude());
        double a =
                Math.sin(radianLatitudeDistance/2) * Math.sin(radianLatitudeDistance/2) +
                        Math.cos(degreesToRadians(cityOne.getLatitude())) * Math.cos(degreesToRadians(cityTwo.getLatitude())) *
                                Math.sin(radianLongitudeDistance/2) * Math.sin(radianLongitudeDistance/2)
                ;
        double radianDistance = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return EARTH_RADIUS * radianDistance;
    }

    private double degreesToRadians(double degrees) {
        return degrees * (Math.PI/180);
    }
}