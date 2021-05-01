# weather-report
A basic api to get weather updates 


Request Type  : GET
Endpoint      : /current
Request Param : location
Reponse       : 200 Ok
ResponseBody  : {
                  "temp": double,
                  "pressure": long,
                  "umbrella": true
                }
                
                
The api internally accessess http://api.openweathermap.org/data/2.5/weather?q={City-name} for getting the weather updates of a city.
It throws a 404 when a city is not found.
