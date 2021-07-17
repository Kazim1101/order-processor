package com.ultra.assessment.processor.service;

import java.util.Map;

import com.ultra.assessment.processor.modal.ProcessOrderRequest;
import com.ultra.assessment.processor.modal.ProcessOrderResponse;

public interface OrderProcessService {
	
	public static final String TOTAL_ORDER_KEY = "totalOrders";
	public static final String AVG_EXECUTION_PRICE_KEY = "avgExecutionPrice";
	
	ProcessOrderResponse processOrder(ProcessOrderRequest orderProcessRequest);
	Map<String, String> getOrderProcessMetrix();
}
