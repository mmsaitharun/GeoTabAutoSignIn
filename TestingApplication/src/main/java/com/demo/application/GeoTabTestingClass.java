package com.demo.application;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.application.dao.GeoTabDao;
import com.demo.application.geotab.Coordinates;
import com.demo.application.util.ServicesUtil;

public class GeoTabTestingClass {
	
	public static void main(String[] args) {
		List<Coordinates> coordList = new ArrayList<Coordinates>();
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF\\spring-servlet.xml");
		ctx.refresh();
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		GeoTabDao geoTabDao = (GeoTabDao) ctx.getBean("geoTabDao");
		
		geoTabDao.
	}

	
	private static Coordinates getAverageCoordinate(List<Coordinates> coordinates) {
		List<Double> latitudes = null;
		List<Double> longitudes = null;
		OptionalDouble averageLatitude = null;
		OptionalDouble averageLongitude = null;
		Coordinates averageCoordinate = null;
		if(!ServicesUtil.isEmpty(coordinates)) {
			latitudes = new ArrayList<Double>();
			longitudes = new ArrayList<Double>();
			for(Coordinates coordinate : coordinates) {
				latitudes.add(coordinate.getLatitude());
				longitudes.add(coordinate.getLongitude());
			}
			averageLatitude = latitudes.stream().mapToDouble(a -> a).average();
			averageLongitude = longitudes.stream().mapToDouble(a -> a).average();
			
			averageCoordinate = new Coordinates(averageLatitude.getAsDouble(), averageLongitude.getAsDouble());
		}
		return averageCoordinate;
	}
	
}
