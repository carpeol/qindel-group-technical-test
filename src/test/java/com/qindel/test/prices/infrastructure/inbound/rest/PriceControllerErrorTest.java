package com.qindel.test.prices.infrastructure.inbound.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerErrorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void returnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/v1/prices/applicablePrice")
                        .param("brandId", "-1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16T21:00:00.000"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("INVALID_FIELD"));
    }

    @Test
    void returnsNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/prices/applicablePrice")
                        .param("brandId", "1")
                        .param("productId", "2")
                        .param("applicationDate", "2020-06-16T21:00:00.000"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorCode").value("APPLICABLE_PRICE_NOT_FOUND"));
    }


    @Test
    void returnsInvalidRequestParameter() throws Exception {
        mockMvc.perform(get("/api/v1/prices/applicablePrice")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16 21:00:00 +02:00"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("INVALID_REQUEST_PARAMETER"));
    }
}
