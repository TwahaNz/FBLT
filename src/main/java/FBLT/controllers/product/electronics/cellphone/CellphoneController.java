package FBLT.controllers.product.electronics.cellphone;

import FBLT.domain.product.electronics.cellphone.CellPhone;
import FBLT.service.product.electronics.cellphone.ImplICellphoneService;
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
public class CellphoneController {

    @Autowired
    ImplICellphoneService cellphoneService;


    //-------------------Retrieve Single Cellphone--------------------------------------------------------
    @RequestMapping(value = "/cellphone-controller/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CellPhone> getCellphone(@PathVariable("id") String id) {
        System.out.println("Fetching request with id: " + id);
        CellPhone request = cellphoneService.readById(id);
        if (request == null) {
            System.out.println("Request with id " + id + "Not Found");
            return new ResponseEntity<CellPhone>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CellPhone>(request, HttpStatus.OK);
    }

    //-------------------Retrieve All Cellphone--------------------------------------------------------

    @RequestMapping(value = "/cellphone-controller/", method = RequestMethod.GET)
    public ResponseEntity<Set<CellPhone>> getCellphones() {
        Set<CellPhone> requests = cellphoneService.readAll();
        if (requests.isEmpty()) {
            return new ResponseEntity<Set<CellPhone>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND http err 204 no content
        }
        return new ResponseEntity<Set<CellPhone>>(requests, HttpStatus.OK);
    }

    //-------------------Update a Cellphone--------------------------------------------------------
    @RequestMapping(value = "/cellphone-controller/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CellPhone> updateCellphone(@PathVariable("id") String id, @RequestBody String Cellphone) {

        CellPhone currentRequest = (CellPhone) cellphoneService.readById(id);

        if (currentRequest == null) {
            return new ResponseEntity<CellPhone>(HttpStatus.NOT_FOUND);
        }

        Gson myGson = new Gson();

        CellPhone updatedCellphone = new CellPhone.Builder()
                .copy(currentRequest)
                .category(myGson.fromJson(Cellphone, CellPhone.class).getCategory())
                .productDescription(myGson.fromJson(Cellphone, CellPhone.class).getDescription())
                .productModel(myGson.fromJson(Cellphone, CellPhone.class).getModel())
                .productMake(myGson.fromJson(Cellphone, CellPhone.class).getMake())
                .build();


        cellphoneService.update(updatedCellphone);
        return new ResponseEntity<CellPhone>(updatedCellphone, HttpStatus.OK);
    }

    //-------------------Insert a Cellphone--------------------------------------------------------
    @RequestMapping(value = "/cellphone-controller/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCellphone(@RequestBody CellPhone newCellphone, UriComponentsBuilder ucBuilder) {

        cellphoneService.create(newCellphone);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cellphone-controller/{id}").buildAndExpand(newCellphone.get_id()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Delete a Cellphone--------------------------------------------------------
    @RequestMapping(value = "/cellphone-controller/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CellPhone> deleteCellphone(@PathVariable("id") String id) {
        CellPhone Cellphone = cellphoneService.readById(id);

        if (Cellphone == null) {
            return new ResponseEntity<CellPhone>(HttpStatus.NOT_FOUND);
        }
        cellphoneService.delete(Cellphone);
        return new ResponseEntity<CellPhone>(HttpStatus.NO_CONTENT);
    }


    // CUSTOM CONTROLLERS

    //-------------------Retrieve CellPhone by specific make--------------------------------------------------------
    @RequestMapping(value = "/cellphone-controller/find-CellPhone-by-make/{make}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CellPhone>> getAudioByMake(@PathVariable("make") String make) {
        System.out.println("Fetching cellphone with make: " + make);
        List<CellPhone> request = cellphoneService.findbymake(make);
        if (request == null) {
            System.out.println("Request with make " + make + "Not Found");
            return new ResponseEntity<List<CellPhone>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<CellPhone>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve CellPhone by specific model--------------------------------------------------------
    @RequestMapping(value = "/cellphone-controller/find-cellphone-by-model/{model}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CellPhone>> getAudioByModel(@PathVariable("model") String model) {
        System.out.println("Fetching CellPhone with model: " + model);
        List<CellPhone> request = cellphoneService.findbymodel(model);
        if (request == null) {
            System.out.println("Request with model " + model + "Not Found");
            return new ResponseEntity<List<CellPhone>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<CellPhone>>(request, HttpStatus.OK);
    }
    
}
