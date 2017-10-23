package com.testeDistance.dao;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.testDistance.entity.City;

public class distanceCity {
	connection conect = new connection();
	
	public List<City> listCity() throws NoSuchAlgorithmException, IOException, InvalidKeyException, SQLException {

		List<City> listCity = new ArrayList<City>();

		Connection conn = conect.getConexaoMySQL();
		Statement st = conn.createStatement();
		
		String queryFindAll = "SELECT * FROM city" ;
		
		ResultSet result = st.executeQuery(queryFindAll);
		
		while(result.next()) {
			City city = new City();
			city.setId(result.getInt("id"));
			city.setLatitude(result.getLong("latitude"));
			city.setLongitude(result.getLong("longitude"));
			city.setName(result.getString("name"));
			listCity.add(city);
		}
		
		st.close();
		
		return listCity;
	}

	public City cityByid(int id) throws NoSuchAlgorithmException, IOException, InvalidKeyException, SQLException {

		
		City city = new City();
		
		Connection conn = conect.getConexaoMySQL();
		Statement st = conn.createStatement();
		
		String queryFindbyid = "SELECT * FROM city WHERE id = "+ id ;
		
		ResultSet result = st.executeQuery(queryFindbyid);
		while(result.next()) {
			city.setId(result.getInt("id"));
			city.setLatitude(result.getLong("latitude"));
			city.setLongitude(result.getLong("longitude"));
			city.setName(result.getString("name"));
		}
		st.close();
		

		return city;	
	}
}
