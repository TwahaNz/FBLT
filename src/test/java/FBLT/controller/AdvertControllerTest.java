package FBLT.controller;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.IProduct;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.vehicle.Vehicle;
import FBLT.utils.genericvalueobjects.Location;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * edited by luke
 * <p>
 * -----------------------------------------THIS TEST WILL ONLY RUN IF THE SERVER IS UP!!!------------------------------
 */


public class AdvertControllerTest {

    private static final String URL = "http://localhost:8080/advert-controller/";



    @Test
    public void testCrud() throws Exception {

        Location newLocation = new Location.Builder()
                .city("Cape Town")
                .suburb("Rondebosch")
                .latitude(22.33)
                .longitude(34.53)
                .build();

        IProduct mynewProduct = new Vehicle.Builder()
                .category(
                        new Category.Builder()
                                .categoryName("Kids Toys")
                                .categoryDescription("things for kids")
                                .build())
                .productDescription("Barbie Doll")
                .build();

        ArrayList<String> images = new ArrayList<>();
        images.add("/webapp/WEB-INF/images/big_ad.png");

        Advert myTestAdvert = new Advert.Builder()

                .buyOrSell(false)
                .price(789.44)
                .product(mynewProduct)
                .location(newLocation)
                .imagePaths(images)
                .build();

        //Insert Advert
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Advert> request = new HttpEntity<>(myTestAdvert);
        ResponseEntity<Advert> response = restTemplate.
                exchange(URL, HttpMethod.POST, request, Advert.class);
        String url = response.getHeaders().getLocation().getPath();
        System.out.println(url);


        //Retrieve one advert
        String ResourceUrl = "http://localhost:8081" + url;
        ResponseEntity<Advert> retrieveOneAdvert = restTemplate.getForEntity(ResourceUrl, Advert.class);
        Assert.assertEquals(retrieveOneAdvert.getStatusCode(), HttpStatus.OK);
        Advert retrievedAdvert = retrieveOneAdvert.getBody();
        Assert.assertEquals("Cape Town", retrievedAdvert.getLocation().getCity());

        //Retrieve all adverts
        ResponseEntity<List> retrieve2 = restTemplate.getForEntity(URL, List.class);
        Assert.assertEquals(retrieve2.getStatusCode(), HttpStatus.OK);
        List<Advert> adverts = retrieve2.getBody();
        Assert.assertTrue(adverts.size() > 0);


        //Update
        newLocation = new Location.Builder()
                .city("MFULENI")
                .suburb("Rondebosch")
                .latitude(22.33)
                .longitude(34.53)
                .build();
        Advert updatedAdvert = new Advert.Builder()
                .copy(retrievedAdvert)
                .location(newLocation)
                .build();
        HttpEntity<Advert> requestUpdate = new HttpEntity<>(updatedAdvert);
        restTemplate.exchange(URL + updatedAdvert.getId(), HttpMethod.PUT, requestUpdate, Void.class);
        retrieveOneAdvert = restTemplate.getForEntity(URL + updatedAdvert.getId(), Advert.class);

        updatedAdvert = retrieveOneAdvert.getBody();
        Assert.assertEquals("MFULENI", updatedAdvert.getLocation().getCity());


//        //DELETE
//        retrieveOneAdvert = restTemplate.exchange(URL + updatedAdvert.getId(), HttpMethod.DELETE, requestUpdate, Advert.class);
//        Assert.assertEquals(HttpStatus.NO_CONTENT, retrieveOneAdvert.getStatusCode());


    }
}
