package com.ultra.assessment.processor.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultra.assessment.processor.modal.ProcessOrderRequest;
import com.ultra.assessment.processor.modal.ProcessOrderResponse;
import com.ultra.assessment.processor.service.OrderProcessService;


@RestController
@RequestMapping("/order/processor")
@CrossOrigin(origins = "*")
public class OrderProcessorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcessorController.class);

	private final OrderProcessService orderProcessService;

	public OrderProcessorController(OrderProcessService orderProcessService) {
		this.orderProcessService = orderProcessService;
	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<ProcessOrderResponse> processOrder(@Valid @RequestBody ProcessOrderRequest request) throws Exception{
		LOGGER.info("OrderRequest recived {}", request.toString());
		return new ResponseEntity<>(orderProcessService.processOrder(request),
				HttpStatus.CREATED);
	}
	
}