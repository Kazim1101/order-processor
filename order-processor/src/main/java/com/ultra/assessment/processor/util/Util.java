package com.ultra.assessment.processor.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Util {

	private static final float UPPER_LIMIT = 2.0f;
	private static final float LOWER_LIMIT = 1.1f;

	public static BigDecimal calculateOrderExecutionPrice(Integer quantiti) {
		DecimalFormat df2 = new DecimalFormat("0.0");
		Float rand = new Random().nextFloat();
		return new BigDecimal(df2.format((float) quantiti * LOWER_LIMIT + (rand * (UPPER_LIMIT - LOWER_LIMIT))));
	}
}
