package com.ultra.assessment.processor.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultra.assessment.processor.controller.OrderProcessorController;
import com.ultra.assessment.processor.entity.OrderEntity;
import com.ultra.assessment.processor.mapper.OrderMapper;
import com.ultra.assessment.processor.modal.IProcessedOrderDetails;
import com.ultra.assessment.processor.modal.ProcessOrderRequest;
import com.ultra.assessment.processor.modal.ProcessOrderResponse;
import com.ultra.assessment.processor.repository.OrderProcessRespository;
import com.ultra.assessment.processor.util.Util;

@Service
public class OrderProcessServiceImpl implements OrderProcessService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcessServiceImpl.class);

	private OrderProcessRespository orderProcessRespository;

	public OrderProcessServiceImpl(OrderProcessRespository orderProcessRespository) {
		this.orderProcessRespository = orderProcessRespository;
	}

	@Override
	public ProcessOrderResponse processOrder(ProcessOrderRequest orderProcessRequest) {
		OrderEntity entity = null;
		try {
			entity = orderProcessRespository.save(OrderMapper.makeOrderEntity(orderProcessRequest,
					Util.calculateOrderExecutionPrice(orderProcessRequest.getQuantiti())));
		} catch (Exception e) {
			LOGGER.error("Error while saving order : {} , with execption {}", orderProcessRequest.getOrderId(),
					e.getMessage());
		}
		return OrderMapper.makeProcessOrderResponse(entity);
	}

	@Override
	public Map<String, String> getOrderProcessMetrix() {
		orderResponse.setOrderId(TOTAL_ORDER_KEY);
		
		Map<String, String> processOrderDetailsMap = new ConcurrentHashMap<>();
		IProcessedOrderDetails processedOrderDetails = null;
		try {
			processedOrderDetails = orderProcessRespository.getProcessOrdersDetails();
		} catch (Exception e) {
			LOGGER.error("Error geting order details {}", e.getMessage());
		}
		if (isResponseValid(processedOrderDetails)) {
			processOrderDetailsMap.put(TOTAL_ORDER_KEY, "0");
			processOrderDetailsMap.put(AVG_EXECUTION_PRICE_KEY, "0");
		} else {
			processOrderDetailsMap.put(TOTAL_ORDER_KEY, processedOrderDetails.getTotalOrders().toString());
			processOrderDetailsMap.put(AVG_EXECUTION_PRICE_KEY,	processedOrderDetails.getExecutionPrice()
							.divide(new BigDecimal(processedOrderDetails.getTotalOrders()), 2, RoundingMode.HALF_UP).toString());
			LOGGER.info("IProcessedOrderDetails : {} : {} , {} , {}", TOTAL_ORDER_KEY, processedOrderDetails.getTotalOrders(),
					AVG_EXECUTION_PRICE_KEY, processedOrderDetails.getExecutionPrice());
		}

		return processOrderDetailsMap;
	}

	private boolean isResponseValid(IProcessedOrderDetails processedOrderDetails) {
		return processedOrderDetails.getTotalOrders() == null
				|| processedOrderDetails.getTotalOrders().compareTo(BigInteger.ZERO) == 0
				|| processedOrderDetails.getExecutionPrice() == null;
	}

}
