package FBLT.controllers.product.electronics.computer;

import FBLT.domain.product.electronics.computer.Computer;
import FBLT.service.product.electronics.computer.ImplIComputerService;
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
 * Created by Ferin on 2016/11/12.
 */

@Controller
public class ComputerController {

    @Autowired
    ImplIComputerService computerService;

    //-------------------Retrieve Single Computer--------------------------------------------------------
    @RequestMapping(value = "/computer-controller/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Computer> getComputer(@PathVariable("id") String id) {
        System.out.println("Fetching request with id: " + id);
        Computer request = computerService.readById(id);
        if (request == null) {
            System.out.println("Request with id " + id + "Not Found");
            return new ResponseEntity<Computer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Computer>(request, HttpStatus.OK);
    }

    //-------------------Retrieve All Computer--------------------------------------------------------

    @RequestMapping(value = "/computer-controller/", method = RequestMethod.GET)
    public ResponseEntity<Set<Computer>> getComputers() {
        Set<Computer> requests = computerService.readAll();
        if (requests.isEmpty()) {
            return new ResponseEntity<Set<Computer>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND http err 204 no content
        }
        return new ResponseEntity<Set<Computer>>(requests, HttpStatus.OK);
    }

    //-------------------Update a Computer--------------------------------------------------------
    @RequestMapping(value = "/computer-controller/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Computer> updateComputer(@PathVariable("id") String id, @RequestBody String Computer) {

        Computer currentRequest = (Computer) computerService.readById(id);

        if (currentRequest == null) {
            return new ResponseEntity<Computer>(HttpStatus.NOT_FOUND);
        }

        Gson myGson = new Gson();

        Computer updatedComputer = new Computer.Builder()
                .copy(currentRequest)
                .category(myGson.fromJson(Computer, Computer.class).getCategory())
                .productDescription(myGson.fromJson(Computer, Computer.class).getDescription())
                .productModel(myGson.fromJson(Computer, Computer.class).getModel())
                .productMake(myGson.fromJson(Computer, Computer.class).getMake())
                .build();


        computerService.update(updatedComputer);
        return new ResponseEntity<Computer>(updatedComputer, HttpStatus.OK);
    }

    //-------------------Insert a Computer--------------------------------------------------------
    @RequestMapping(value = "/computer-controller/", method = RequestMethod.POST)
    public ResponseEntity<Void> createComputer(@RequestBody Computer newComputer, UriComponentsBuilder ucBuilder) {

        computerService.create(newComputer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/computer-controller/{id}").buildAndExpand(newComputer.get_id()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Delete a Computer--------------------------------------------------------
    @RequestMapping(value = "/computer-controller/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Computer> deleteComputer(@PathVariable("id") String id) {
        Computer Computer = computerService.readById(id);

        if (Computer == null) {
            return new ResponseEntity<Computer>(HttpStatus.NOT_FOUND);
        }
        computerService.delete(Computer);
        return new ResponseEntity<Computer>(HttpStatus.NO_CONTENT);
    }


    // CUSTOM CONTROLLERS

    //-------------------Retrieve Computer by specific make--------------------------------------------------------
    @RequestMapping(value = "/computer-controller/find-computer-by-make/{make}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Computer>> getComputerByMake(@PathVariable("make") String make) {
        System.out.println("Fetching computer with make: " + make);
        List<Computer> request = computerService.findbymake(make);
        if (request == null) {
            System.out.println("Request with make " + make + "Not Found");
            return new ResponseEntity<List<Computer>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Computer>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve Computer by specific model--------------------------------------------------------
    @RequestMapping(value = "/computer-controller/find-computer-by-model/{model}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Computer>> getComputerByModel(@PathVariable("model") String model) {
        System.out.println("Fetching computer with model: " + model);
        List<Computer> request = computerService.findbymodel(model);
        if (request == null) {
            System.out.println("Request with model " + model + "Not Found");
            return new ResponseEntity<List<Computer>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Computer>>(request, HttpStatus.OK);
    }


}
