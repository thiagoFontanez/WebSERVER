package com.testDistance.entity;

import java.util.ArrayList;
import java.util.List;

public class DistanceFactory {

    public static List<Distance> buildDistances(List<City> cityList, MeasureUnit measureUnit){
        List<Distance> distances = new ArrayList<>();

        cityList.forEach(city -> {
            if(isNotLastCity(cityList, city)){
                for(int i = nextIndex(cityList, city); i < cityList.size(); i++){
                    distances.add(new Distance(city, cityList.get(i), measureUnit));
                }
            }
        });

        return distances;
    }

    private static int nextIndex(List<City> cityList, City city) {
        return cityList.indexOf(city) + 1;
    }

    private static boolean isNotLastCity(List<City> cityList, City city) {
        return !(cityList.indexOf(city) == cityList.size() - 1);
    }
}
