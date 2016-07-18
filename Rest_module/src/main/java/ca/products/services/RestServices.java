package ca.products.services;

import ca.products.jpa_models.Member;
import ca.products.jpa_models.Product;
import ca.products.jpa_models.ShoppingBag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.persist.Transactional;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by mtaboubi on 16-07-14.
 */

@Path("/")
public class RestServices {


    private ObjectMapper serializer;
    Logger logger = LoggerFactory.getLogger(RestServices.class);


    @GET
    @Transactional
    @Path("/member")
    public void createMember() throws JSONException {

        logger.info("Processing Create Member");

        Member member = new Member("pseudonym");
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
            EntityManager em = emf.createEntityManager();

            em.persist(member);
            em.flush();

        } catch (Exception e) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }
    }

    @POST
    @Path("/member")
    public void createMember(JSONObject memberObject) throws JSONException {

        logger.info("Processing Create Member");

        Member member = new Member(memberObject.getJSONObject("pseudonym").toString());
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            if (!em.contains(member)) {
                em.persist(member);
                em.flush();
            }
            em.getTransaction().commit();

            em.close();
            emf.close();

        } catch (Exception e) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }
    }

    @GET
    @Path("/listMembers")
    public Response listAllMembers() {

        logger.info("Processing list all existing Members");

        List<Member> members = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
        EntityManager em = emf.createEntityManager();

        members.addAll(em.createQuery("SELECT object(e) FROM Member e").getResultList());

        em.close();
        emf.close();

        serializer = new ObjectMapper();
        try {
            return Response.status(200).entity(serializer.writeValueAsString(members)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/listShoppingBag")
    public Response listShoppingBag() {

        logger.info("Listing shopping Bag for a member");

        List<ShoppingBag> shoppingBags = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
        EntityManager em = emf.createEntityManager();

        shoppingBags.addAll(em.createQuery("SELECT object(e) FROM ShoppingBag e").getResultList());

        em.close();
        emf.close();

        serializer = new ObjectMapper();
        try {
            return Response.status(200).entity(serializer.writeValueAsString(shoppingBags)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/listCatalogue")
    public Response listAllProductsInCatalogue() {

        logger.info("Processing list all existing Products in the catalogue");

        List<Product> products = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
        EntityManager em = emf.createEntityManager();

        products.addAll(em.createQuery("SELECT object(e) FROM Product e").getResultList());

        em.close();
        emf.close();

        serializer = new ObjectMapper();
        try {
            return Response.status(200).entity(serializer.writeValueAsString(products)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/reset")
    public void resetData() {

        logger.info("Processing reset");
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            for (int i = 0; i < 10; i++) {
                em.persist(new Product("Product_" + i, "Desc_" + i));
            }

            for (int i = 0; i < 10; i++) {
                ShoppingBag s = new ShoppingBag();
                em.persist(s);
                Member m = new Member("Member_" + i);
                s.setMember(m);
                em.persist(m);
            }

            em.flush();
            em.getTransaction().commit();

            em.close();
            emf.close();

        } catch (Exception e) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }

    }
}
