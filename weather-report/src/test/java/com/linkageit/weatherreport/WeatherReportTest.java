/*
package com.linkageit.weatherreport;


import com.linkageit.weatherreport.controller.WeatherController;
import com.linkageit.weatherreport.model.WeatherReportResponse;
import com.linkageit.weatherreport.service.WeatherReportService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
public class WeatherReportTest {

    //@Autowired
    //private WeatherController weatherController;

    @MockBean
    private WeatherReportService weatherReportService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestTemplate restTemplate;

    private WeatherReportResponse weatherReportResponse;

    private static final String CITY1 = "London";
    private static final String CITY2 = "Berlin";
    private static final String CITY3 = "abc123";

    private static final String API_URL = "/current?Location=";

    private String jsonStr = "{\"data\":{\"temp\":277.8,\"pressure\":1010,\"umbrella\":false},\"statusCode\":200,\"recordCount\":1,\"message\":\"Weather report for London\"}";

    */
/*@BeforeAll
    public void init() {

        //ReflectionTestUtils.setField(weatherReportService, "openweatherurl", "http://api.openweathermap.org/data/2.5/weather?q=");
        //ReflectionTestUtils.setField(weatherReportService, "appid", "fe7a5de42789a144805014ce1b61bbc1");

        //MockitoAnnotations.initMocks(this);
    }*//*


    */
/*@Test
    public void contextLoads() throws Exception {
        assertThat(weatherController).isNotNull();
    }*//*


    @Test
    public void getWeatherReportForCity() throws Exception {

        weatherReportResponse = new WeatherReportResponse();
        weatherReportResponse.setPressure(124l);
        weatherReportResponse.setTemp(12);
        weatherReportResponse.setUmbrella(false);

        when(weatherReportService.isUmbrellaRequired(CITY1)).thenReturn(weatherReportResponse);

        this.mockMvc.perform(get(API_URL+CITY3))
                    .andExpect(status().isOk())
                    .andExpect(content().json("{\"success\":false,\"message\":\"Location not found.\"}"))
                    .andReturn();
    }

    */
/*@Test(expected = FileNotFoundException.class)
    public void getWeatherReportForNonExistingCity() throws ParseException {
        weatherReportService.isUmbrellaRequired(CITY3);
    }*//*

}
*/
