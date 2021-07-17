package com.ultra.assessment.processor.modal;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface IProcessedOrderDetails {
    BigInteger getTotalOrders();
    BigDecimal getExecutionPrice();
}