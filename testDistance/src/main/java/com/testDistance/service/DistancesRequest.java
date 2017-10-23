package com.testDistance.service;

import javax.xml.bind.annotation.XmlRootElement;

import com.testDistance.entity.MeasureUnit;

@XmlRootElement(name = "root")
public class DistancesRequest{
	private MeasureUnit measureUnit;

	public MeasureUnit getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(MeasureUnit measureUnit) {
		this.measureUnit = measureUnit;
	}
}

