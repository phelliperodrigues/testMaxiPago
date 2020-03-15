# PROJECT - DISTANCE BETWEEN TWO CITIES
**GOAL**
* Provide web service that returns list with combination of city pairs and distance between them.

---

## Done with:
<p>
Below are tools used in the development of distance test between distances, specified for the back-end:

---
- [Java 13](http://oracle.com/technetwork/java/13-relnote-issues-5460548.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MariaDB](https://mariadb.org/)
- [Maven](https://maven.apache.org/)

## List of available cities
* GET

``` localhost: 8080/```
<br/>**Accept: application/json**
```
[
    {
        "id": "1",
        "name": "New York",
        "longitude": 40.7144,
        "latitude": -74.006
    },
    {
        "id": "2",
        "name": "Sao Paulo",
        "longitude": -23.5505,
        "latitude": -46.6333
    },
    {
        "id": "3",
        "name": "Buenos Aires",
        "longitude": -34.6037,
        "latitude": -58.3816
    }
]
```


<br/>**Accept: application/xml**
```
<List>
    <item>
        <id>1</id>
        <name>New York</name>
        <longitude>40.7144</longitude>
        <latitude>-74.006</latitude>
    </item>
    <item>
        <id>2</id>
        <name>Sao Paulo</name>
        <longitude>-23.5505</longitude>
        <latitude>-46.6333</latitude>
    </item>
    <item>
        <id>3</id>
        <name>Buenos Aires</name>
        <longitude>-34.6037</longitude>
        <latitude>-58.3816</latitude>
    </item>
</List>
```

---
## Calculation of distance between two cities
**GET**

- KILOMETRO <br/>
  - Attribute unit=km
```localhost: 8080/distance? cityA=1 & cityB=2 & unit=km```
- **Accept: application/json**
```
{
    "distance": 4297.57,
    "unit": "km"
}
```

- MILES <br/>
- Attribute unit=mi
```localhost: 8080/distance? cityA=1 & cityB=2 & unit=mi```
- **Accept: application/json**
```
{
    "distance": 2668.79,
    "unit": "mi"
}
```
- KILOMETRO <br/>
- Attribute unit=km
```localhost: 8080/distance? cityA=1 & cityB=2 & unit=km```
- **Accept: application/xml**
```
<Distance>
    <distance>4297.57</distance>
    <unit>km</unit>
</Distance>
```

- MILES <br/>
- Attribute unit=mi
```localhost: 8080/distance? cityA=1 & cityB=2 & unit=mi```
- **Accept: application/xml**
```
<Distance>
    <distance>2668.79</distance>
    <unit>mi</unit>
</Distance>
```

- WRONG PARAMETERS <br/>
. Attribute Unit!=Mi, km
```localhost: 8080/distance? cityA=1 & cityB=2 & unit=xxx```
- **Accept: application/xml**
```
Invalidate the unit
Accept only: km, mi
```

- WRONG PARAMETERS <br/>
. City not registered
```localhost:8080/distance?cityA=1001&cityB=2&unit=mi```
- **Accept: application/xml**
```
City not found
```
### To calculate the distance used in the Haversine formula:

The Haversine formula is an important equation used in navigation, providing distances between two points on a sphere from latitudes and longitudes. It is a special case of a more general formula for spherical trigonometry, a Haversine law, relating the sides to angles of a "triangular" sphere.

These names are due to the fact that they are written in terms of the haversine function, given by a haversin (θ)=sine² (θ/2). (Since formulas can also be written in terms of a multiple of Haversine, as the previous function versa (twice or Haversine). Historically or Haversine may have an advantage of its maximum value, then the logistical variables of its values ​​end at 0. Today, the Haversine formula is also convenient because it has no sine function coefficient²


[Reference: Rosseta Code](https://rosettacode.org/wiki/Haversine_formula#Java)