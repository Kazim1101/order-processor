package com.ultra.assessment.processor.modal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "orderId", "symbol", "quantiti" })
public class ProcessOrderRequest {

	@JsonProperty("orderId")
	private String orderId;
	@JsonProperty("symbol")
	private String symbol;
	@JsonProperty("quantiti")
	private Integer quantiti;

	public ProcessOrderRequest(String orderId, String symbol, Integer quantiti) {
		super();
		this.orderId = orderId;
		this.symbol = symbol;
		this.quantiti = quantiti;
	}

	@JsonProperty("orderId")
	public String getOrderId() {
		return orderId;
	}

	@JsonProperty("orderId")
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@JsonProperty("symbol")
	public String getSymbol() {
		return symbol;
	}

	@JsonProperty("symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@JsonProperty("quantiti")
	public Integer getQuantiti() {
		return quantiti;
	}

	@JsonProperty("quantiti")
	public void setQuantiti(Integer quantiti) {
		this.quantiti = quantiti;
	}

	@Override
	public String toString() {
		return "ProcessOrderRequest [orderId=" + orderId + ", symbol=" + symbol + ", quantiti=" + quantiti + "]";
	}

	public static ProcessOrderDTOBuilder newBuilder() {
		return new ProcessOrderDTOBuilder();
	}

	public static class ProcessOrderDTOBuilder {

		private String orderId;
		private String symbol;
		private Integer quantiti;

		public ProcessOrderDTOBuilder setOrderId(String orderId) {
			this.orderId = orderId;
			return this;
		}
		public ProcessOrderDTOBuilder setSymbol(String symbol) {
			this.symbol = symbol;
			return this;
		}


		public ProcessOrderDTOBuilder setQuantiti(Integer quantiti) {
			this.quantiti = quantiti;
			return this;
		}

		public ProcessOrderRequest createProcessOrderDTO() {
			return new ProcessOrderRequest(orderId, symbol, quantiti);
		}

	}
}
