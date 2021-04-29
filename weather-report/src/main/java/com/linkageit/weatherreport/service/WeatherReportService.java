package com.linkageit.weatherreport.service;

import com.linkageit.weatherreport.model.WeatherReportResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.linkageit.weatherreport.enums.WeatherConditions.*;

@Service
public class WeatherReportService {

    @Value("${openweather.api.url}")
    private String openweatherurl;

    @Value("${openweather.api.key}")
    private String appid;

    private static final String GET = "GET";

    public WeatherReportResponse isUmbrellaRequired(String city) throws ParseException {
        StringBuffer content=null;
        try {
            URL url = new URL(openweatherurl + city + "&appid=" + appid);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(GET);

            InputStream response = con.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine + "\n");
            }
        }catch(FileNotFoundException e){
            return null;
        }catch(IOException e){
            e.printStackTrace();
        }

        //Parsing and collecting the response string
        JSONParser parser = new JSONParser();
        JSONObject obj1 = (JSONObject)parser.parse(content.toString());
        JSONArray jsonArray = (JSONArray)obj1.get("weather");
        JSONObject weatherConditionObject = (JSONObject) jsonArray.get(0);
        String mainResponse = (String)weatherConditionObject.get("main");
        WeatherReportResponse weatherReportResponse = new WeatherReportResponse();

        //Checking if umbrella is required
        if(mainResponse.equalsIgnoreCase(DRIZZLE.name()) || mainResponse.equalsIgnoreCase(THUNDERSTORM.name())
        || mainResponse.equalsIgnoreCase(RAIN.name()))
            weatherReportResponse.setUmbrella(true);

        //Setting temperature and pressure
        JSONObject mainObject = (JSONObject)obj1.get("main");
        weatherReportResponse.setTemp((double)mainObject.get("temp"));
        weatherReportResponse.setPressure((long)mainObject.get("pressure"));

        return weatherReportResponse;
    }
}
