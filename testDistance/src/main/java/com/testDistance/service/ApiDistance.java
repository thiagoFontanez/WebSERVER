package com.testDistance.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.testDistance.entity.Distance;
import com.testDistance.entity.DistanceFactory;
import com.testeDistance.dao.connection;
import com.testDistance.entity.City;
import com.testeDistance.dao.distanceCity;


@Path("/calc")
public class ApiDistance {
    // Initialize new album service.
	distanceCity city = new distanceCity();
	connection conect = new connection();
	
    // Define GET method and resource.
    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public List<City> listciTy() throws InvalidKeyException,
            NoSuchAlgorithmException, IOException, SQLException {

        return city.listCity();
    }
    @GET
    @Path("/listByid")
    @Produces({MediaType.APPLICATION_JSON})
    public City cityid(@QueryParam("id") int id) throws InvalidKeyException,
            NoSuchAlgorithmException, IOException, SQLException {
    	
        // Return list of albums.
        return city.cityByid(id);
    }
    
    @POST
    @Path("/distances")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Distance> distances(DistancesRequest distancesRequest) throws NoSuchAlgorithmException, IOException, InvalidKeyException, SQLException{
    	List<City> cities = city.listCity();
        return DistanceFactory.buildDistances(cities, distancesRequest.getMeasureUnit());
    }
}

