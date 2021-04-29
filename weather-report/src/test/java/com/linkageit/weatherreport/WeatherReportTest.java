/*
package com.linkageit.weatherreport;

import com.linkageit.weatherreport.model.WeatherReportResponse;
import com.linkageit.weatherreport.service.WeatherReportService;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileNotFoundException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherReportTest {

    @InjectMocks
    private WeatherReportService weatherReportService;

    @Autowired
    private MockMvc mockMvc;



    private WeatherReportResponse weatherReportResponse;

    private static final String CITY1 = "London";

    private static final String CITY2 = "Berlin";

    private static final String CITY3 = "abc123";

    private static final String API_URL = "/weather?Location=";

    private String jsonStr = "{\"data\":{\"temp\":277.8,\"pressure\":1010,\"umbrella\":false},\"statusCode\":200,\"recordCount\":1,\"message\":\"Weather report for London\"}";

    @Before
    public void init() {
        weatherReportResponse = new WeatherReportResponse();
        weatherReportResponse.setPressure(124l);
        weatherReportResponse.setTemp(12);
        weatherReportResponse.setUmbrella(false);

        ReflectionTestUtils.setField(weatherReportService, "openweatherurl", "http://api.openweathermap.org/data/2.5/weather?q=");
        ReflectionTestUtils.setField(weatherReportService, "appid", "fe7a5de42789a144805014ce1b61bbc1");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getWeatherReportForCity() throws Exception {
        when(weatherReportService.isUmbrellaRequired(CITY1)).thenReturn(any());

        this.mockMvc.perform(get(API_URL+CITY1))
                    .andExpect(status().isOk())
                    .andExpect(content().json(jsonStr))
                    .andReturn();
    }

    @Test(expected = FileNotFoundException.class)
    public void getWeatherReportForNonExistingCity() throws ParseException {
        weatherReportService.isUmbrellaRequired(CITY3);
    }
}
*/
