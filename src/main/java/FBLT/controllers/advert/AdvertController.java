package FBLT.controllers.advert;

import FBLT.domain.advert.Advert;
import FBLT.service.advert.ImplAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by maybra01 on 10/12/2016.
 */
@RestController
public class AdvertController {
    @Autowired
    ImplAdvertService requestService;


    //-------------------Retrieve Single Advert--------------------------------------------------------
    @RequestMapping(value = "/advert-controller/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Advert> getRequest(@PathVariable("id") long id) {
        System.out.println("Fetching request with id: " + id);
      /*  //Advert request = requestService.readById(id);
        if (request == null) {
            System.out.println("Request with id " + id + "Not Found");
            return new ResponseEntity<Advert>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Advert>(request, HttpStatus.OK);*/
        return null;
    }

    //-------------------Retrieve All Adverts--------------------------------------------------------

    @RequestMapping(value = "/advert-controller/", method = RequestMethod.GET)
    public ResponseEntity<Set<Advert>> getRequests() {
        Set<Advert> requests = requestService.readAll();
        if (requests.isEmpty()) {
            return new ResponseEntity<Set<Advert>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND http err 204 no content
        }
        return new ResponseEntity<Set<Advert>>(requests, HttpStatus.OK);
    }


}
