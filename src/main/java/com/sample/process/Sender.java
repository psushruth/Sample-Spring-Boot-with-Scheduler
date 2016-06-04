package com.sample.process;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.process.domain.AppRequest;
import com.sample.process.domain.AppResponse;
import com.sample.process.exception.IdExistsException;

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
	    
	    request.setMissionId(String.valueOf(count.incrementAndGet()));
	    
	    if ( request.getMissionId().equalsIgnoreCase("2"))
	    	request.setMissionId("1");
	    int seed = random.nextInt(max - min + 1) + min;
	    request.setSeed(seed);
	    try {
			System.out.println("Request="+ mapper.writeValueAsString(request));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<AppResponse> result = null; 
	    boolean isExists = false;
	    
	    try {
	    	result = restTemplate.postForEntity(url, request, AppResponse.class);
	    } catch (HttpClientErrorException e) {
	    	if ( e.getMessage().contains("409"))
	    		isExists = true;
	    }
	    System.out.println("Response:");
	    
	    if ( isExists )
	    	System.out.println("HTTP code= 409");
	    else {
	    	System.out.println("HTTP code="+ result.getStatusCode());
	    	try {
				System.out.println("Body="+mapper.writeValueAsString(result.getBody()));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				System.out.println("bad json");
			}
	    }
	    
	    System.out.println("\n\n");
	    
	}
} 
