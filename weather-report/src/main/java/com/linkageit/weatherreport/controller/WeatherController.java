package com.linkageit.weatherreport.controller;

import com.linkageit.weatherreport.model.BaseResponse;
import com.linkageit.weatherreport.model.WeatherReportResponse;
import com.linkageit.weatherreport.service.WeatherReportService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/current")
    public ResponseEntity<BaseResponse> getWeatherReport(@RequestParam(name = "location")final String city) throws IOException, ParseException {
        WeatherReportResponse data = weatherReportService.isUmbrellaRequired(city);
        BaseResponse response = null;
        if(data==null) {
            response = new BaseResponse("City not found",404,0,"No data present for "+city);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response = new BaseResponse(data, 200, 1, "Weather report for "+city);
        return ResponseEntity.ok(response);
    }
}
