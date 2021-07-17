package com.ultra.assessment.processor.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
//import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
//import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.ultra.assessment.processor.service.OrderProcessService;

@Component
@Endpoint(id = "ordermetrix")
public class OrderMetrixEndpoint {
  
    private final OrderProcessService orderProcessService;

	public OrderMetrixEndpoint(OrderProcessService orderProcessService) {
		this.orderProcessService = orderProcessService;
	}

    @ReadOperation
    public Map<String, String> features() {
        return orderProcessService.getOrderProcessMetrix();
    }
    
}