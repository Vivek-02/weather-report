package com.linkageit.weatherreport;

import com.linkageit.weatherreport.controller.WeatherController;
import com.linkageit.weatherreport.model.WeatherReportResponse;
import com.linkageit.weatherreport.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WeatherControllerTest{

    @MockBean
    private WeatherReportService weatherReportService;

    @Autowired
    private WeatherController weatherController;

    @Autowired
    private MockMvc mockMvc;

    private WeatherReportResponse weatherReportResponse;

    private String jsonStr = "{\"data\":{\"temp\":277.8,\"pressure\":1010,\"umbrella\":false},\"statusCode\":200,\"recordCount\":1,\"message\":\"Weather report for London\"}";

    private static final String CITY1 = "London";
    private static final String CITY2 = "Berlin";
    private static final String CITY3 = "abc123";

    @BeforeEach
    public void init(){
        weatherReportResponse = new WeatherReportResponse();
        weatherReportResponse.setPressure(124l);
        weatherReportResponse.setTemp(12);
        weatherReportResponse.setUmbrella(false);
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(weatherController).isNotNull();
    }

    @Test
    public void shouldGetDefaultWeatherResponse() throws Exception {

        this.mockMvc.perform(get("/current?location="+CITY1)).andExpect(status().is(404));

        this.mockMvc.perform(get("/current?location="+CITY2)).andDo(print()).andExpect(status().is(404));

        when(weatherReportService.isUmbrellaRequired(CITY1)).thenReturn(weatherReportResponse);

        MockHttpServletResponse mvcResult = this.mockMvc.perform(get("/current?location="+CITY1))
                    .andExpect(status().isOk())
                    .andReturn().getResponse();

    }


}