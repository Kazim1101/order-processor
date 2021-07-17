package com.ultra.assessment.processor.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@AutoConfigureMockMvc
public abstract class AbstractRestIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	protected WebApplicationContext wac;

	@Autowired
	protected MockMvc mockMvc;

}
