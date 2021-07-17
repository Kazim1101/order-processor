package com.ultra.assessment.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ultra.assessment.processor.entity.OrderEntity;
import com.ultra.assessment.processor.modal.IProcessedOrderDetails;

public interface OrderProcessRespository extends JpaRepository<OrderEntity, String> {

	@Query("SELECT COUNT(c.quantiti) AS totalOrders, SUM(c.executionPrice) AS executionPrice FROM OrderEntity AS c")
	IProcessedOrderDetails getProcessOrdersDetails();
}
