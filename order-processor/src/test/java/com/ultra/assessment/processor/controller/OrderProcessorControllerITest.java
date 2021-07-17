package com.ultra.assessment.processor.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ultra.assessment.processor.modal.ProcessOrderRequest;
import com.ultra.assessment.processor.modal.ProcessOrderResponse;
import com.ultra.assessment.processor.service.OrderProcessService;
import com.ultra.assessment.processor.test.AbstractRestIntegrationTest;

public class OrderProcessorControllerITest extends AbstractRestIntegrationTest {

	@Mock
	private OrderProcessService orderProcessorService;

	@Autowired
	private OrderProcessorController orderProcessorController;

	@Before
	public void setup() {
		orderProcessorController = new OrderProcessorController(orderProcessorService);
	}

	@Test
	public void shouldSaveProduct() {

		UUID id = UUID.randomUUID();
		// given
		ProcessOrderRequest orderRequest = new ProcessOrderRequest("001", "GOOG", 4);

		// when
		when(orderProcessorService.processOrder(orderRequest))
				.thenReturn(new ProcessOrderResponse("001", new BigDecimal(4)));

		// then
		ResponseEntity<ProcessOrderResponse> responseEntityResponseEntity = null;
		try {
			responseEntityResponseEntity = orderProcessorController.processOrder(orderRequest);
			assertThat(responseEntityResponseEntity.getStatusCode(), is(HttpStatus.CREATED));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
