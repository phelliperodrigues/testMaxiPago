package com.phellipe.distanceCities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.jfree.util.Log;
import org.springframework.stereotype.Component;

import com.phellipe.distanceCities.factory.ConnectionFactory;
import com.phellipe.distanceCities.model.City;

@Component
public class CityDAO {

	private Connection connection;
	private ResultSet rs;
	private PreparedStatement stm;

	public CityDAO() {

		this.connection = ConnectionFactory.getConnection();
	}

	public Map<String, City> getCities() {

		HashMap<String, City> result = new HashMap<>();

		try {
			if (this.connection != null && this.connection.isClosed()) {
				this.connection = ConnectionFactory.getConnection();
			}
			String sql = "SELECT id, name, latitude, longitude FROM city";

			stm = this.connection.prepareStatement(sql);

			rs = stm.executeQuery();

			while (rs.next()) {

				City city = new City(rs.getString("id"), rs.getString("name"), rs.getDouble("latitude"),
						rs.getDouble("longitude"));

				result.put(rs.getString("id"), city);

			}

			rs.close();
			stm.close();
			this.connection.close();

		} catch (Exception e) {
			Log.error(e);
			return null;
		}

		return result;

	}

	public City getCity(String idCity) {

		City city = null;

		try {
			
			if (this.connection != null && this.connection.isClosed()) {
				this.connection = ConnectionFactory.getConnection();
			}
			
			String sql = "SELECT id, name, latitude, longitude FROM city WHERE id = ?";

			PreparedStatement stm = this.connection.prepareStatement(sql);
			stm.setString(1, idCity);

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {

				city = new City(rs.getString("id"), rs.getString("name"), rs.getDouble("latitude"),
						rs.getDouble("longitude"));
								

			}

			rs.close();
			stm.close();
			connection.close();

		} catch (Exception e) {
			Log.error(e);
			return null;
		}

		return city;

	}

}
