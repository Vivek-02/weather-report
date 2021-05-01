# weather-report
A basic api to get weather updates </br>


Request Type  : GET </br>
Endpoint      : /current  </br>
Request Param : location  </br>
Reponse       : 200 Ok  </br>
ResponseBody  : { </br>
                  "temp": double, </br>
                  "pressure": long, </br>
                  "umbrella": true  </br>
                } </br>
                
                
The api internally accessess http://api.openweathermap.org/data/2.5/weather?q={City-name} for getting the weather updates of a city. </br>
It throws a 404 when a city is not found. </br>
