package ca.products.services;

import ca.products.jpa_models.Member;
import ca.products.jpa_models.Product;
import ca.products.jpa_models.ShoppingBag;
import ca.products.repositories.MemberRepository;
import ca.products.repositories.ProductRepository;
import ca.products.repositories.ShoppingBagRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.inject.persist.Transactional;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by mtaboubi on 16-07-14.
 */

@Path("/")
public class RestServices {

    @Inject
    private Provider<EntityManager> em;

    @Inject
    ProductRepository productRepository;

    @Inject
    MemberRepository memberRepository;

    @Inject
    ShoppingBagRepository shoppingBagRepository;

    private ObjectMapper serializer;
    Logger logger = LoggerFactory.getLogger(RestServices.class);


    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addProduct")
    public void addProductToShoppingBag(JSONObject object) throws JSONException {

        logger.info("adding Product to a shopping bag");

        try {

            String memberId = object.get("member_id").toString();

            ArrayList<String> listProducts_id = new ArrayList<>();
            JSONArray jArray = object.getJSONArray("products_id");
            if (jArray != null) {
                for (int i = 0; i < jArray.length(); i++) {
                    listProducts_id.add(jArray.get(i).toString());
                }
            }

            ShoppingBag shoppingBag = shoppingBagRepository.findByMemberID(memberId);
            Set<Product> productSet = shoppingBag.getProduct();

            for (String product_new_id : listProducts_id) {

                Product product_new = productRepository.find(product_new_id);
                productSet.add(product_new);
            }

            shoppingBag.setProduct(productSet);
            shoppingBagRepository.persist(shoppingBag);

        } catch (Exception e) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }
    }

    @GET
    @Transactional
    @Path("/listMembers")
    public Response listAllMembers() {

        logger.info("Processing list all existing Members");

        List<Member> members = new ArrayList<>();

        members.addAll(memberRepository.listAllMembers());

        serializer = new ObjectMapper();
        try {
            return Response.status(200).entity(serializer.writeValueAsString(members)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @Transactional
    @Path("/listShoppingBag")
    public Response listShoppingBag(@QueryParam("member_id") String member_id) {

        logger.info("Listing shopping Bag for a member");

        ShoppingBag shoppingBag = shoppingBagRepository.findByMemberID(member_id);
        Set<Product> productSet = shoppingBag.getProduct();

        serializer = new ObjectMapper();
        try {
            return Response.status(200).entity(serializer.writeValueAsString(productSet)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @Transactional
    @Path("/listProductsCatalogue")
    public Response listAllProductsInCatalogue() {

        logger.info("Processing list all existing Products in the catalogue");

        List<Product> products = new ArrayList<>();

        products.addAll(productRepository.listAllProductsInCatalogue());

        serializer = new ObjectMapper();
        try {
            return Response.status(200).entity(serializer.writeValueAsString(products)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @Transactional
    @Path("/loadProductByID")
    public Response loadProductByID(@QueryParam("product_id") String product_id) throws JSONException {

        logger.info("Load Product by ID");

        try {
            List<Product> response = productRepository.findProductByID(product_id);
            serializer = new ObjectMapper();
            return Response.status(200).entity(serializer.writeValueAsString(response)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @Transactional
    @Path("/reset")
    public Response resetData() {

        logger.info("Processing reset");
        try {

            productRepository.resetProductDB();
            shoppingBagRepository.resetShoppingBagDB();
            memberRepository.resetMembersDB();

        } catch (Exception e) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }
        return Response.status(200).build();

    }
}
