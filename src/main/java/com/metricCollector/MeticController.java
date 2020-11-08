package com.metricCollector;

import java.util.Date;//The class Date represents a specific instant in time, with millisecond precision.


import java.util.ArrayList;//provides resizable-array and implements the List interface

import java.util.Calendar; //The Calendar class is an abstract class that provides methods for converting between a specific instant in time and a set of calendar fields such as YEAR

import java.util.List;//List interface provides four methods for positional (indexed) access

import java.util.Map;//The Map interface provides three collection views, which allow a map's contents to be viewed as a set of  key-value mappings.


import java.sql.Timestamp; //This class is a thin wrapper around java.util.Date that allows JDBC to identify this as a SQL TIMESTAMP value. It adds the ability to hold the SQL TIMESTAMP


import org.springframework.beans.factory.annotation.Autowired;//Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities. 

import org.springframework.web.bind.annotation.GetMapping;//Annotation for mapping HTTP GET requests onto specific handler methods.

import org.springframework.web.bind.annotation.PostMapping;//Annotation for mapping HTTP POST requests onto specific handler methods.

import org.springframework.web.bind.annotation.RequestBody;//used to bind the HTTP request/response body with a domain object in method parameter or return type.

import org.springframework.web.bind.annotation.RequestParam;// to extract query parameters

import org.springframework.web.bind.annotation.RestController; //It's a convenience annotation that combines @Controller and @ResponseBody 

@RestController
public class MeticController {
	
	@Autowired
	metricRepo metricrepo;
	
	@PostMapping("/metric" ) //endpoint for posting data
	int saveMetric(@RequestBody Map<String,List<Integer>> data)
	{if(data.get("data").size()==0)//if data size is null
		{return 0;
		}
		
	List<Integer> al;
	al=data.get("data");
		for(int i=0; i<al.size() ; i++)
	{
		metric m=new metric();
		m.setData(al.get(i));
		//System.out.println(al.get(i));
		 Date date = new Date();
	        System.out.println(new Timestamp(date.getTime()));
		Timestamp t =new Timestamp(date.getTime());
		m.setDate(t);//seting t in m
		metricrepo.save(m);
		
	}
		return 1; //if svae succfulle return 1
		
	}
	
	
	@GetMapping("/metric" )
	Long getSum(@RequestParam String time)
	{
	
	
	ArrayList<metric> res = (ArrayList<metric>) metricrepo.findAll();
	long sum=-1;
	Date date = new Date();
   Timestamp curr=new Timestamp(date.getTime());
   
   if(time.equals("5m"))
   {sum=0;
	for(metric m :res)
	{
		if(comp(curr,m.getDate())<=5)
		{
			sum+=m.getData();
		}
	}
   }
   else  if(time.equals("10m"))
   {sum=0;
	for(metric m :res)
	{
		if(comp(curr,m.getDate())<=10)
		{
			sum+=m.getData();
		}
	}
   }
   else  if(time.equals("30m"))
   {sum=0;
	for(metric m :res)
	{
		if(comp(curr,m.getDate())<=30)
		{
			sum+=m.getData();
		}
	}
   }
   
   
	   return  sum;
	}
	
	
	public static long comp(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime)
	{
	    long milliseconds1 = oldTime.getTime();
	  long milliseconds2 = currentTime.getTime();

	  long diff = milliseconds2 - milliseconds1;
	  long diffSeconds = diff / 1000;
	  long diffMinutes = diff / (60 * 1000);
	  long diffHours = diff / (60 * 60 * 1000);
	  long diffDays = diff / (24 * 60 * 60 * 1000);

	    return diffMinutes;
	}
	
	
}
