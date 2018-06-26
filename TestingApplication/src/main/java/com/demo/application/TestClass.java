package com.demo.application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.demo.application.dto.DateTimeDto;
import com.demo.application.geotab.util.GeoTabUtil;

public class TestClass {

	//geotab time// 3hr 49 min 45 sec
	//utc time// 2:13:20
	
	//currstate duration//03:31:27.0630000
	//datetime//2018-06-14T01:54:53.063Z
	
	public static void main(String[] args) throws JSONException, ParseException {
		
		Long dateDifference = null;
		Long seperateDateTime = null;
		Long finalDateTime = null;
		DateTimeDto durationBreakdown = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date currentDateTime = null;
		try {
			currentDateTime = dateFormat.parse(dateFormat.format(new Date()));
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		
		String deviceInfoEntity = "{ \"method\":\"Get\", \"params\": { \"credentials\": { \"database\":\"murphy_oil\", \"password\":\"$tr3amlin3\", \"userName\":\"SVC_IOP@murphyoilcorp.com\" }, \"typeName\": \"DeviceStatusInfo\", \"search\" : { \"deviceSearch\" : {\"id\" : \"bA6\"} } } }";
		
		JSONObject result = GeoTabUtil.callRest(deviceInfoEntity);
		
		System.out.println("Rest Result : "+result);
		
		JSONArray resultArray = result.getJSONArray("result");
		
		JSONObject deviceInfo = (JSONObject) resultArray.get(0);
		
		System.out.println(deviceInfo);
		System.out.println(deviceInfo.getString("currentStateDuration"));
		
//		dateDifference = currentDateTime.getTime() - dateFormat.parse(deviceInfo.getString("dateTime")).getTime();
//		seperateDateTime = GeoTabUtil.seperateDateTime(deviceInfo.getString("currentStateDuration"));
////		finalDateTime = dateDifference + seperateDateTime;
//		finalDateTime = seperateDateTime;
//		durationBreakdown = GeoTabUtil.getDurationBreakdown(finalDateTime);
//		System.out.println("Parked Time : "+dateFormat.format(GeoTabUtil.getParkedTime(durationBreakdown)));
//		System.out.println(GeoTabUtil.getDurationBreakdown(currentDateTime.getTime() - GeoTabUtil.getParkedTime(durationBreakdown).getTime()));
		
		String dateTime = deviceInfo.getString("dateTime");
		String currentStateDuration = deviceInfo.getString("currentStateDuration");
		
		seperateDateTime = GeoTabUtil.seperateDateTime(currentStateDuration);
		
		Long parkedTime = seperateDateTime + (dateFormat.parse(dateTime)).getTime();
		
		Date parkedDate = new Date();
		parkedDate.setTime(parkedTime);
		
		System.out.println(dateFormat.format(parkedDate));
		
		Date currentDate = new Date();
		
		Long diff = (dateFormat.parse(dateFormat.format(parkedDate))).getTime() - (dateFormat.parse(dateFormat.format(currentDate))).getTime();
		
		System.out.println("diff  : "+diff);
		
		System.out.println(GeoTabUtil.getDurationBreakdown(diff));
		
	}
}
