package ca.products.services;

import ca.products.jpa_models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by mtaboubi on 16-07-14.
 */

@Path("/")
public class RestServices {


    private ObjectMapper serializer;

    @GET
    @Path("/listCatalogue")
    public Response listAllCatalogue() {

        // Get All Products in the catalogue
        List<Product> products = new ArrayList<>();

        serializer = new ObjectMapper();
        try {
            return Response.status(200).entity(serializer.writeValueAsString(products)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/listBag")
    public Response listAllBag() {

        // Get All Products in the actual Bag
        List<Product> products = new ArrayList<>();

        serializer = new ObjectMapper();
        try {
            return Response.status(200).entity(serializer.writeValueAsString(products)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @POST
    @Path("/{product_id}")
    public Response setRandomCollectionFeatures(@PathParam("product_id") int product_id) {

        Product product = new Product();

        serializer = new ObjectMapper();

        try {
            return Response.status(200).entity(serializer.writeValueAsString(product)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }


    }
}
