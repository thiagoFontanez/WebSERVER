package com.testDistance.entity;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

public class DistanceFactoryTest {

    @Test
    public void GivenAListOfCitiesWith5CitiesWhenBuildCityPairsThenACityPairListWith10PairsIsCreated(){
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("A"));
        cities.add(new City("B"));
        cities.add(new City("C"));
        cities.add(new City("D"));
        cities.add(new City("E"));

        List<Distance> distances = DistanceFactory.buildDistances(cities, MeasureUnit.KILOMETERS);

        assertThat(distances.size(), equalTo(10));
    }

    @Test
    public void GivenAListOfCitiesWhenBuildCityPairsThenAListOfCityPairsIsCreated(){
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("A"));
        cities.add(new City("B"));
        cities.add(new City("C"));

        List<Distance> distances = DistanceFactory.buildDistances(cities, MeasureUnit.KILOMETERS);

        assertThat(distances.get(0).getCityOne().getName(), equalTo("A"));
        assertThat(distances.get(0).getCityTwo().getName(), equalTo("B"));
        assertThat(distances.get(1).getCityOne().getName(), equalTo("A"));
        assertThat(distances.get(1).getCityTwo().getName(), equalTo("C"));
        assertThat(distances.get(2).getCityOne().getName(), equalTo("B"));
        assertThat(distances.get(2).getCityTwo().getName(), equalTo("C"));
    }
}
