package com.app.consumer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClientTest {

	public static void main(String[] args) {
		String url="http://localhost:8080/Spring5RestProviderApp/emp/data";
		
		// Http Headers
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/xml");
		//body
		String json="{\"empId\":10,\"empName\":\"AB\",\"empSal\":3.3}";
		
		//Http Entity
		HttpEntity<String> entity=new HttpEntity<String>(json, headers);
		
		// Template
		RestTemplate rt=new RestTemplate();
		
		//make POST call
		ResponseEntity<String> resp=rt.postForEntity(url, entity, String.class);
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getStatusCode().name());
		
		
		
	}
	
	
	public static void main1(String[] args) {
		String url="http://localhost/Spring5RestProviderApp/emp/show";               
		
		RestTemplate rt=new RestTemplate();
		
		ResponseEntity<String> resp=rt.getForEntity(url, String.class);
		//ResponseEntity<String> resp=rt.postForEntity(url, null, String.class);
		
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getStatusCode().name());
		System.out.println("done");
		
	}
}


