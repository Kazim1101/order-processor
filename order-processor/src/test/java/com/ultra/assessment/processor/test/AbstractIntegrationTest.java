package com.ultra.assessment.processor.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.ApplicationContext;

@AutoConfigureWireMock(port = 0)
public abstract class AbstractIntegrationTest extends AbstractTest {

    @Autowired
    protected ApplicationContext context;

}
