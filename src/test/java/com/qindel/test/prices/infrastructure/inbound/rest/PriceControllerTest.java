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
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void returnsPriceListOneAtTenOnJuneFourteenth() throws Exception {
        assertApplicablePrice("2020-06-14T10:00:00.000", 1L);
    }

    @Test
    void returnsPriceListTwoAtSixteenOnJuneFourteenth() throws Exception {
        assertApplicablePrice("2020-06-14T16:00:00.000", 2L);
    }

    @Test
    void returnsPriceListOneAtTwentyOneOnJuneFourteenth() throws Exception {
        assertApplicablePrice("2020-06-14T21:00:00.000", 1L);
    }

    @Test
    void returnsPriceListThreeAtTenOnJuneFifteenth() throws Exception {
        assertApplicablePrice("2020-06-15T10:00:00.000", 3L);
    }

    @Test
    void returnsPriceListFourAtTwentyOneOnJuneSixteenth() throws Exception {
        assertApplicablePrice("2020-06-16T21:00:00.000", 4L);
    }

    private void assertApplicablePrice(String applicationDate, Long expectedPriceList) throws Exception {
        mockMvc.perform(get("/api/v1/prices/applicablePrice")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", applicationDate))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.priceId").value(expectedPriceList));
    }
}
