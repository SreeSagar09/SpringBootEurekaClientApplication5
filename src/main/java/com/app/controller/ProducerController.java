package com.app.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/producer")
public class ProducerController {
	
	@GetMapping(path = "/getData")
	public ResponseEntity<Map<String, String>> getData(HttpServletRequest httpServletRequest){
		
		ResponseEntity<Map<String, String>> responseEntity = null;
		try {
			Map<String, String> responseMap = new LinkedHashMap<>();
			responseMap.put("class", "ProducerController");
			responseMap.put("method", "getData");
			responseMap.put("requestedURI", httpServletRequest.getRequestURI());
			responseMap.put("port", String.valueOf(httpServletRequest.getServerPort()));
			responseMap.put("localAddress", httpServletRequest.getLocalAddr());
			responseMap.put("remoteAddress", httpServletRequest.getRemoteAddr());
			
			responseEntity = new ResponseEntity<Map<String,String>>(responseMap, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
