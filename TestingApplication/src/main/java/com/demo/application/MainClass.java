package com.demo.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.application.dao.GeoTabDao;
import com.demo.application.geotab.util.GeoTabUtil;

public class MainClass {

	public static void main(String[] args) {
		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		Date currentDateTime = new Date();

		
//		dateDifference = currentDateTime.getTime() - dateFormat.parse(deviceInfo.getDateTime()).getTime();
//		seperateDateTime = GeoTabUtil.seperateDateTime(deviceInfo.getCurrentStateDuration());
//		finalDateTime = dateDifference + seperateDateTime;
//		durationBreakdown = GeoTabUtil.getDurationBreakdown(finalDateTime);
//		deviceInfo.setParkedDateTime(dateFormat.format(GeoTabUtil.getParkedTime(durationBreakdown)));
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF\\spring-servlet.xml");
		ctx.refresh();
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		GeoTabDao geoTabDao = (GeoTabDao) ctx.getBean("geoTabDao");
		
//		final long startTime = System.nanoTime();
		System.out.println(GeoTabUtil.signInUsers(geoTabDao));
//		final long duration = System.nanoTime() - startTime;
//		System.out.println("Seconds : "+TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS));
//		System.out.println(GeoTabUtil.getUsers(28.93730148850197, -97.83679244375092));
		ctx.close();
	}
}
