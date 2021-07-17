package com.ultra.assessment.processor.mapper;

import java.math.BigDecimal;

import com.ultra.assessment.processor.entity.OrderEntity;
import com.ultra.assessment.processor.modal.ProcessOrderRequest;
import com.ultra.assessment.processor.modal.ProcessOrderResponse;

public class OrderMapper {

	public static OrderEntity makeOrderEntity(ProcessOrderRequest orderRequest, BigDecimal executionPrice) {
		return new OrderEntity(orderRequest.getOrderId(), orderRequest.getSymbol(), orderRequest.getQuantiti(), executionPrice);
	}
	
	public static ProcessOrderResponse makeProcessOrderResponse(OrderEntity orderEntity) {
		return new ProcessOrderResponse(orderEntity.getOrderId(), orderEntity.getExecutionPrice());
	}
	
}
