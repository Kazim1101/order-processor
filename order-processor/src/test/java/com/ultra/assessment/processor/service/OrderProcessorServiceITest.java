package com.ultra.assessment.processor.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ultra.assessment.processor.modal.ProcessOrderRequest;
import com.ultra.assessment.processor.modal.ProcessOrderResponse;
import com.ultra.assessment.processor.test.AbstractIntegrationTest;

public class OrderProcessorServiceITest extends AbstractIntegrationTest{

	@Autowired
	private OrderProcessService orderProcessService;
	
	@Test
	public void processOrderCreattion() {
		ProcessOrderRequest orderRequest = new ProcessOrderRequest("001", "GOOG", 4);
		
		ProcessOrderResponse processOrderResponse = orderProcessService.processOrder(orderRequest);
		
		assertThat(processOrderResponse.getOrderId(),is(orderRequest.getOrderId()));
	}
	
}
