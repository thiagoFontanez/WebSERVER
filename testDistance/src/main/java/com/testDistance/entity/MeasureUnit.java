package com.testDistance.entity;

import java.util.HashMap;
import java.util.Map;

public enum MeasureUnit {
	KILOMETERS,
    MILES;
	
	private static final double KILOMETERS_TO_KILOMETERS_FACTOR = 1.0;
	private static final double KILOMETERS_TO_MILES_FACTOR = 0.621371;
	private static Map<MeasureUnit, Double> factorsMap = new HashMap<>();
	
	static {
		factorsMap.put(KILOMETERS, KILOMETERS_TO_KILOMETERS_FACTOR);
		factorsMap.put(MILES, KILOMETERS_TO_MILES_FACTOR);
	}
	
	protected double conversionFactor() {	
		return factorsMap.get(this);
	}
}
