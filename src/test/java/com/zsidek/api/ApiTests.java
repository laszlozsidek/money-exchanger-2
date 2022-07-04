package com.zsidek.api;

import com.zsidek.service.FinanceService;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class ApiTests {

    FinanceService financeService = new FinanceService();

    @Test
    void testIfEndpointWorks() {
        Response response = financeService.getResponseOfQuoteEndpoint();
        int statusCode = response.statusCode();
        log.info("Status code: {}", statusCode);
        Assertions.assertThat(statusCode).withFailMessage("Endpoint is not working").isIn(HttpStatus.SC_OK, HttpStatus.SC_FORBIDDEN);
        log.info("Endpoint is working");
    }

}