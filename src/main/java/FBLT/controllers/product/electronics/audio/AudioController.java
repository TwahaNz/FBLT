package FBLT.controllers.product.electronics.audio;

import FBLT.domain.product.electronics.audio.Audio;
import FBLT.service.product.electronics.audio.ImplIAudioService;
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
public class AudioController {

    @Autowired
    ImplIAudioService audioService;


    //-------------------Retrieve Single Audio--------------------------------------------------------
    @RequestMapping(value = "/audio-controller/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Audio> getAudio(@PathVariable("id") String id) {
        System.out.println("Fetching request with id: " + id);
        Audio request = audioService.readById(id);
        if (request == null) {
            System.out.println("Request with id " + id + "Not Found");
            return new ResponseEntity<Audio>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Audio>(request, HttpStatus.OK);
    }

    //-------------------Retrieve All Audio--------------------------------------------------------

    @RequestMapping(value = "/audio-controller/", method = RequestMethod.GET)
    public ResponseEntity<Set<Audio>> getAudios() {
        Set<Audio> requests = audioService.readAll();
        if (requests.isEmpty()) {
            return new ResponseEntity<Set<Audio>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND http err 204 no content
        }
        return new ResponseEntity<Set<Audio>>(requests, HttpStatus.OK);
    }

    //-------------------Update an Audio--------------------------------------------------------
    @RequestMapping(value = "/audio-controller/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Audio> updateAudio(@PathVariable("id") String id, @RequestBody String audio) {

        Audio currentRequest = (Audio) audioService.readById(id);

        if (currentRequest == null) {
            return new ResponseEntity<Audio>(HttpStatus.NOT_FOUND);
        }

        Gson myGson = new Gson();

        Audio updatedAudio = new Audio.Builder()
                .copy(currentRequest)
                .category(myGson.fromJson(audio, Audio.class).getCategory())
                .productAmps(myGson.fromJson(audio, Audio.class).getAmps())
                .productWatts(myGson.fromJson(audio, Audio.class).getWatts())
                .productDescription(myGson.fromJson(audio, Audio.class).getDescription())
                .productModel(myGson.fromJson(audio, Audio.class).getModel())
                .productMake(myGson.fromJson(audio, Audio.class).getMake())
                .build();


        audioService.update(updatedAudio);
        return new ResponseEntity<Audio>(updatedAudio, HttpStatus.OK);
    }

    //-------------------Insert an Audio--------------------------------------------------------
    @RequestMapping(value = "/audio-controller/", method = RequestMethod.POST)
    public ResponseEntity<Void> createAudio(@RequestBody Audio newAudio, UriComponentsBuilder ucBuilder) {

        audioService.create(newAudio);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/audio-controller/{id}").buildAndExpand(newAudio.get_id()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Delete an Audio--------------------------------------------------------
    @RequestMapping(value = "/audio-controller/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Audio> deleteAudio(@PathVariable("id") String id) {
        Audio audio = audioService.readById(id);

        if (audio == null) {
            return new ResponseEntity<Audio>(HttpStatus.NOT_FOUND);
        }
        audioService.delete(audio);
        return new ResponseEntity<Audio>(HttpStatus.NO_CONTENT);
    }


    // CUSTOM CONTROLLERS

    //-------------------Retrieve audio with specific WATTS--------------------------------------------------------
    @RequestMapping(value = "/audio-controller/find-audio-by-watts/{watts}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Audio>> getAudioByWatts(@PathVariable("watts") String watts) {
        System.out.println("Fetching audio with watts: " + watts);
        List<Audio> request = audioService.findbywatts(watts);
        if (request == null) {
            System.out.println("Request with watts " + watts + "Not Found");
            return new ResponseEntity<List<Audio>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Audio>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve audio by specific make--------------------------------------------------------
    @RequestMapping(value = "/audio-controller/find-audio-by-make/{make}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Audio>> getAudioByMake(@PathVariable("make") String make) {
        System.out.println("Fetching audio with make: " + make);
        List<Audio> request = audioService.findbymake(make);
        if (request == null) {
            System.out.println("Request with watts " + make + "Not Found");
            return new ResponseEntity<List<Audio>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Audio>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve audio by specific model--------------------------------------------------------
    @RequestMapping(value = "/audio-controller/find-audio-by-model/{model}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Audio>> getAudioByModel(@PathVariable("model") String model) {
        System.out.println("Fetching audio with model: " + model);
        List<Audio> request = audioService.findbymodel(model);
        if (request == null) {
            System.out.println("Request with model " + model + "Not Found");
            return new ResponseEntity<List<Audio>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Audio>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve audio by specific amps--------------------------------------------------------
    @RequestMapping(value = "/audio-controller/find-audio-by-amps/{amps}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Audio>> getAudioByAmps(@PathVariable("amps") String amps) {
        System.out.println("Fetching audio with model: " + amps);
        List<Audio> request = audioService.findbyamps(amps);
        if (request == null) {
            System.out.println("Request with amps " + amps + "Not Found");
            return new ResponseEntity<List<Audio>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Audio>>(request, HttpStatus.OK);
    }
}
