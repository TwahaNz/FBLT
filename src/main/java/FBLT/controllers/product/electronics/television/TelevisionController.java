package FBLT.controllers.product.electronics.television;

import FBLT.domain.product.electronics.television.Television;
import FBLT.service.product.electronics.television.ImplITelevisionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;

/**
 * Created by student on 2016/11/12.
 */
@Controller
public class TelevisionController {

    @Autowired
    ImplITelevisionService televisionService;

    //-------------------Retrieve Single Television--------------------------------------------------------
    @RequestMapping(value = "/television-controller/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Television> getTelevision(@PathVariable("id") String id) {
        System.out.println("Fetching request with id: " + id);
        Television request = televisionService.readById(id);
        if (request == null) {
            System.out.println("Request with id " + id + "Not Found");
            return new ResponseEntity<Television>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Television>(request, HttpStatus.OK);
    }

    //-------------------Retrieve All Television--------------------------------------------------------

    @RequestMapping(value = "/television-controller/", method = RequestMethod.GET)
    public ResponseEntity<Set<Television>> getTelevisions() {
        Set<Television> requests = televisionService.readAll();
        if (requests.isEmpty()) {
            return new ResponseEntity<Set<Television>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND http err 204 no content
        }
        return new ResponseEntity<Set<Television>>(requests, HttpStatus.OK);
    }

    //-------------------Update a Television--------------------------------------------------------
    @RequestMapping(value = "/television-controller/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Television> updateTelevision(@PathVariable("id") String id, @RequestBody String Television) {

        Television currentRequest = (Television) televisionService.readById(id);

        if (currentRequest == null) {
            return new ResponseEntity<Television>(HttpStatus.NOT_FOUND);
        }

        Gson myGson = new Gson();

        Television updatedTelevision = new Television.Builder()
                .copy(currentRequest)
                .category(myGson.fromJson(Television, Television.class).getCategory())
                .productDescription(myGson.fromJson(Television, Television.class).getDescription())
                .productModel(myGson.fromJson(Television, Television.class).getModel())
                .productMake(myGson.fromJson(Television, Television.class).getMake())
                .build();


        televisionService.update(updatedTelevision);
        return new ResponseEntity<Television>(updatedTelevision, HttpStatus.OK);
    }

    //-------------------Insert a Television--------------------------------------------------------
    @RequestMapping(value = "/television-controller/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTelevision(@RequestBody Television newTelevision, UriComponentsBuilder ucBuilder) {

        televisionService.create(newTelevision);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/television-controller/{id}").buildAndExpand(newTelevision.get_id()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Delete a Television--------------------------------------------------------
    @RequestMapping(value = "/television-controller/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Television> deleteTelevision(@PathVariable("id") String id) {
        Television Television = televisionService.readById(id);

        if (Television == null) {
            return new ResponseEntity<Television>(HttpStatus.NOT_FOUND);
        }
        televisionService.delete(Television);
        return new ResponseEntity<Television>(HttpStatus.NO_CONTENT);
    }


    // CUSTOM CONTROLLERS

    //-------------------Retrieve Television by specific make--------------------------------------------------------
    @RequestMapping(value = "/television-controller/find-television-by-make/{make}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Television>> getTelevisionByMake(@PathVariable("make") String make) {
        System.out.println("Fetching television with make: " + make);
        List<Television> request = televisionService.findbymake(make);
        if (request == null) {
            System.out.println("Request with make " + make + "Not Found");
            return new ResponseEntity<List<Television>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Television>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve Television by specific model--------------------------------------------------------
    @RequestMapping(value = "/television-controller/find-television-by-model/{model}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Television>> getTelevisionByModel(@PathVariable("model") String model) {
        System.out.println("Fetching television with model: " + model);
        List<Television> request = televisionService.findbymodel(model);
        if (request == null) {
            System.out.println("Request with model " + model + "Not Found");
            return new ResponseEntity<List<Television>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Television>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve Television by specific size--------------------------------------------------------
    @RequestMapping(value = "/television-controller/find-television-by-size/{size}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Television>> getTelevisionBySize(@PathVariable("size") String size) {
        System.out.println("Fetching television with model: " + size);
        List<Television> request = televisionService.findbymodel(size);
        if (request == null) {
            System.out.println("Request with model " + size + "Not Found");
            return new ResponseEntity<List<Television>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Television>>(request, HttpStatus.OK);
    }

}
