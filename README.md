# weather-report
A basic api to get weather updates </br>


Request Type  &nbsp; : &nbsp; GET </br>
Endpoint      &nbsp; : &nbsp; /current  </br>
Request Param &nbsp; : &nbsp; location  </br>
Reponse       &nbsp; : &nbsp; 200 Ok  </br>
ResponseBody  &nbsp; : &nbsp; { </br>
&nbsp; &nbsp; &nbsp; "temp": &nbsp; double, </br>
&nbsp; &nbsp; &nbsp; "pressure": &nbsp; long, </br>
&nbsp; &nbsp; &nbsp; "umbrella": &nbsp; boolean  </br>
&nbsp; &nbsp;   } </br>
                
                
The api internally accessess http://api.openweathermap.org/data/2.5/weather?q={city-name} for getting the weather updates of a city. </br>
It throws a 404 when a city is not found. </br>
