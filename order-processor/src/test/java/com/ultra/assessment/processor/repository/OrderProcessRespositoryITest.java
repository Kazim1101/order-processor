package com.ultra.assessment.processor.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.ultra.assessment.processor.entity.OrderEntity;
import com.ultra.assessment.processor.modal.IProcessedOrderDetails;
import com.ultra.assessment.processor.test.AbstractIntegrationTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderProcessRespositoryITest extends AbstractIntegrationTest{

	@Autowired
	private OrderProcessRespository orderProcessRespository;

	@Test
	public void aorderProcessSave() {
		orderProcessRespository.deleteAll();
		OrderEntity orderEntity = new OrderEntity("002", "GOOG", 4, new BigDecimal(4.5));
		OrderEntity entityResponse = orderProcessRespository.save(orderEntity);
		assertThat(entityResponse.getOrderId(), is(orderEntity.getOrderId()));
	}
		
	@Test
	public void getOrderProcessExecutionPrice() {
		IProcessedOrderDetails processedOrderDetailsResponse = orderProcessRespository.getProcessOrdersDetails();
		assertThat(processedOrderDetailsResponse.getTotalOrders(), is(BigInteger.valueOf(1)));
	}
}
