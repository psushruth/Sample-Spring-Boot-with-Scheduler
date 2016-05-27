package com.sample.process.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.sample.process.EulerAlgorithm;
import com.sample.process.Sender;
import com.sample.process.domain.AppRequest;
import com.sample.process.domain.AppResponse;
import com.sample.process.exception.IdExistsException;
import com.sample.process.service.AppService;

import javax.inject.Inject;
import javax.validation.Valid;

@RestController
public class AppController {

    private final AppService appService;

    @Inject
    public AppController(final AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public AppResponse createUser(@RequestBody @Valid final AppRequest request) {
    	
    	if ( request == null )
    		return null;
    	
    	if ( appService.save(request) != null ) {
    		long answer = EulerAlgorithm.getInstance().findSum(request.getSeed());
        	AppResponse response = new AppResponse(); 
        	response.setAnswer(answer);
        	return response;
    	}
    	else
    		return null;
    }
    
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(IdExistsException e) {
        return e.getMessage();
    }

}
