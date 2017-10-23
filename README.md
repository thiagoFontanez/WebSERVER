# WebSERVER

To start this project, you need to have the following items on your machine:
- mySQL
- have a server "tomCAT 8.x.x"
- download the project "testDistance"


Starting dB
************************************************
- go in the browse open http://127.0.0.1/phpmyadmin or any other mySql db,
- be running dB on local port 3306.
- create database with name = "distanceCity"
- import the dataBase that is in the dB_file folder, it contains the table and dump.
- the user should be = "root"
- and the passwor is does not have = ""

Obs -> If you have your own settings, please go to /testDistance/src/main/java/com/testeDistance/dao/connection.java

change the following data

String serverName = "yourLocal: yourPort";
String mydatabase = "YourDataBase";
String username = "yourUsernamedB";
String password = "yourPassword";




Starting application
************************************************

step 0. enter the folder of the testDistance project and execute the following commands
		-> mvn clean package
		-> mvn install
step 1. Include the testDistance.war file for the Tomcat webapps folder
step 2. go to tomcat-> va bin folder and start tomcat.
step 3. go to the browser put in the URL "http://localhost:8080/testDistance /list"
obs - accessing the URL http://localhost: 8080/testDistance /list, should return all data in the table "city [id, name, latitude, longitude]"
"Connection problems will be evidenced in the server's LOG file".


Consuming webServe API RestFUl
***********************************************
use PostMan or Related.
URL API -> http://localhost:8080/testDistance/distances

bodyVAlue json-> {"measureUnit": "MILES"} or {"measureUnit": "KILOMETERS"}

bodyValue xml -> <? xml version = "1.0" encoding = "UTF-8"?>
					<root>
					<measureUnit> MILES </ measureUnit>
					</ root>

Additional information on the Project
************************************************** *

Included TDD tests -> in sorting algorithms, ensuring your city pair by arrangement without repetition.
Included TDD test -> in Distance algorithm, ensuring the return of cities in "KM" or "Miles"


Algorithm of Ordination of the List of Cities -> It was adopted the method by "simple combination" of "Arrangement"
for being a simple combination of ((n) elements X (n) elements) with Binominal coefficient, an improvement was included
where it will not repeat combining values.
ex: Set elements = {a, b, c, d}
Result of the algorithm {[a, b], [a, c], [a, d], [b, c], [b, d], [c, d]}
OBS-> by of combinations between cities, no matter their repeated combination as
{[a, b], [b, a]} because its distance is the same between the two points.

Calculus Algorithm between cities -> Adopted the formula of 'HAVERSINE', This formula gives us a good approximation when applied to the Earth,
even though the earth is not a perfect sphere: its radius varies from 6356.78 km at the poles to 6378.14 km at the equator.
These small corrections, on the order of 0.1% to 0.5% (assuming R = 6367.45 km) are used everywhere due to the light ellipsoidal shape of our planet.
Therefore, this formula answers the problem proposed by calculating a margin of error between 0.1% and 0.5%.
