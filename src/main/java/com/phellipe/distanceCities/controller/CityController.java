package com.phellipe.distanceCities.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phellipe.distanceCities.calculator.CalcDistance;
import com.phellipe.distanceCities.dao.CityDAO;
import com.phellipe.distanceCities.exception.CityException;
import com.phellipe.distanceCities.model.City;
import com.phellipe.distanceCities.model.Distance;

@Controller
public class CityController {

	CityDAO dao = new CityDAO();

	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<City> getCities() {
		List<City> cities = new ArrayList<City>();
		try {

			dao.getCities().forEach((id, city) -> {
				cities.add(city);
			});

		} catch (Exception e) {
			Log.error(e);
		}
		return cities;
	}
	
	@GetMapping(path = "/distance", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<?> getDistance(@RequestParam("cityA") String idCityA, 
			@RequestParam("cityB") String idCityB,
			@RequestParam("unit") String unit) throws IOException, CityException {
		
		if (!unit.equals("km") && !unit.equals("mi")) {
			return ResponseEntity.ok("Unit invalide\nAccept only: km, mi");
		}	

		City cityA = dao.getCity(idCityA);
		City cityB = dao.getCity(idCityB);
		
		if (cityA == null || cityB == null) {
			return ResponseEntity.ok("City not found");

		}

		double result = new CalcDistance().getDistance(cityA, cityB, unit);
		
		Distance distance = new Distance(result, unit);
		return ResponseEntity.ok(distance);

	}

}
