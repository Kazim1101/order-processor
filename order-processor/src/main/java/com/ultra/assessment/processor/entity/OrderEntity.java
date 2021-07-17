package com.ultra.assessment.processor.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = 4977890325872050927L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ORDER_ID")
	private String orderId;

	@Column(name =  "SYMBOL")
	@NotNull
	private String symbol;

	@Column(name = "QUANTITI")
	@NotNull
	private Integer quantiti;
	
	@Column(name = "EXECUTION_PRICE")
	private BigDecimal executionPrice;

	public OrderEntity() {
		super();
	}

	public OrderEntity(String orderId, String symbol, Integer quantiti, BigDecimal executionPrice) {
		super();
		this.orderId = orderId;
		this.symbol = symbol;
		this.quantiti = quantiti;
		this.executionPrice = executionPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getQuantiti() {
		return quantiti;
	}

	public void setQuantiti(Integer quantiti) {
		this.quantiti = quantiti;
	}
	
	public BigDecimal getExecutionPrice() {
		return executionPrice;
	}

	public void setExecutionPrice(BigDecimal executionPrice) {
		this.executionPrice = executionPrice;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderId=" + orderId + ", symbol=" + symbol + ", quantiti=" + quantiti
				+ ", executionPrice=" + executionPrice + "]";
	}

}
