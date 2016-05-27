package com.sample.process;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.process.domain.AppRequest;
import com.sample.process.domain.AppResponse;

@Service
public class Sender {
	
	final String url = "http://localhost:8080/messages";
	private int max = 20000;
	private int min = 1000;
	private Random random = new Random();
	private AtomicInteger count = new AtomicInteger(0);
	ObjectMapper mapper = new ObjectMapper();
	
	@Scheduled(fixedDelay=3000)
	public void countStudent(){
	   sendMessage();
	}	
	
	private void sendMessage()
	{
	    AppRequest request = new AppRequest();
	    
	    request.setId(String.valueOf(count.incrementAndGet()));
	    int seed = random.nextInt(max - min + 1) + min;
	    request.setSeed(seed);
	    System.out.println("Request: MissionId="+request.getId()+", Seed="+request.getSeed());
	     
	    RestTemplate restTemplate = new RestTemplate();
	    AppResponse result = restTemplate.postForObject(url, request, AppResponse.class);
	    
	    System.out.println("Response: answer="+result.getAnswer());
	    try {
			System.out.println("Response json="+mapper.writeValueAsString(result));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("bad json");
		}
	    
	}
} 
