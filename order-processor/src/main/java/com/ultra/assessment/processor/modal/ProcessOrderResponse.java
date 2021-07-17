package com.ultra.assessment.processor.modal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "orderId", "executionPrice" })
public class ProcessOrderResponse {

	@JsonProperty("orderId")
	private String orderId;
	@JsonProperty("executionPrice")
	private BigDecimal executionPrice;	
	
	public ProcessOrderResponse(String orderId, BigDecimal executionPrice) {
		super();
		this.orderId = orderId;
		this.executionPrice = executionPrice;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public BigDecimal getExecutionPrice() {
		return executionPrice;
	}
	public void setExecutionPrice(BigDecimal executionPrice) {
		this.executionPrice = executionPrice;
	}
	
}

