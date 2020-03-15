[<img src="https://cdn.icon-icons.com/icons2/107/PNG/512/brazil_18295.png" width=40>](https://github.com/phelliperodrigues/testMaxiPago/blob/master/LEIAME.md) Português - Brasil
[<img src="https://download.seaicons.com/download/i86350/custom-icon-design/round-world-flags/custom-icon-design-round-world-flags-usa.ico" width=40>](https://github.com/phelliperodrigues/testMaxiPago/blob/master/README.md) Inglês



# PROJETO - DISTÂNCIA ENTRE DUAS CIDADES 
**OBJETIVO**
* Fornecer webservice que retorna lista com combinação de pares de cidades e distância entre elas.

---

## Feito com:
<p>
Abaixo seguem as ferramentas utilizadas no desenvolvimento do teste de calculo entre distancia, especificamente para o Back-end:

---

  - [Java 13](http://oracle.com/technetwork/java/13-relnote-issues-5460548.html)
  - [Spring Boot](https://spring.io/projects/spring-boot)
  - [MariaDB](https://mariadb.org/)
  - [Maven](https://maven.apache.org/)

## Lista de Cidades Disponiveis
* GET

```localhost:8080/```
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
## Calculo de distancia entre duas cidades
**GET**
  
- KILOMETRO <br/> 
  
    - Atributo unit = km
```localhost:8080/distance?cityA=1&cityB=2&unit=km```
 - **Accept: application/json**
```
{
    "distance": 4297.57,
    "unit": "km"
}
```

  - MILES <br/>
    - Atributo unit = mi
```localhost:8080/distance?cityA=1&cityB=2&unit=mi```
 - **Accept: application/json**
```
{
    "distance": 2668.79,
    "unit": "mi"
}
```
- KILOMETRO <br/>
    - Atributo unit = km
```localhost:8080/distance?cityA=1&cityB=2&unit=km```
 - **Accept: application/xml**
```
<Distance>
    <distance>4297.57</distance>
    <unit>km</unit>
</Distance>
```

  - MILES <br/>
    - Atributo unit = mi
```localhost:8080/distance?cityA=1&cityB=2&unit=mi```
 - **Accept: application/xml**
```
<Distance>
    <distance>2668.79</distance>
    <unit>mi</unit>
</Distance>
```

  - PARAMETROS ERRADOS <br/>
. Atributo unit !=  mi, km
```localhost:8080/distance?cityA=1&cityB=2&unit=xxx```
 - **Accept: application/xml**
```
Unit invalide
Accept only: km, mi
```

  - PARAMETROS ERRADOS <br/>
    . Cidade não cadastrada

```localhost:8080/distance?cityA=1001&cityB=2&unit=mi```
 - **Accept: application/xml**
```
City not found
```
### Para o calculo da distancia utilizei a fórmula Haversine:

A fórmula de Haversine é uma importante equação usada em navegação, fornecendo distâncias entre dois pontos de uma esfera a partir de suas latitudes e longitudes. É um caso especial de uma fórmula mais geral de trigonometria esférica, a lei dos Haversines, relacionando os lados a ângulos de uma esfera "triangular".

Estes nomes se devem ao fato de que são escritos nos termos da função haversine , dado por um haversin(θ) = seno²(θ/2). (As fórmulas podem ser também escritas em termos de um múltiplo do Haversine, como função anterior versine (duas vezes o Haversine). Historicamente o Haversine tem talvez a ligeira vantagem de seu máximo ser um, então tabelas logarítmicas de seus valores terminam em zero. Hoje a fórmula de Haversine é também conveniente pelo fato de não ter coeficiente da função seno²


[Referencia: Rosseta Code](https://rosettacode.org/wiki/Haversine_formula#Java)
