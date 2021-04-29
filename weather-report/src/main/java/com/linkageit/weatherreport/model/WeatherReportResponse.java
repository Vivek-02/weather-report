package com.linkageit.weatherreport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherReportResponse {

    private double temp;

    private long pressure;

    private boolean umbrella;
}
