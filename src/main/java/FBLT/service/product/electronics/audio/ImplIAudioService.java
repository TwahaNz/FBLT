package FBLT.service.product.electronics.audio;

import FBLT.domain.product.electronics.audio.Audio;
import FBLT.repositories.product.electronics.audio.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by student on 2016/11/12.
 */

@Service
public class ImplIAudioService implements IAudioService {

    @Autowired
    AudioRepository repository;


    @Override
    public List<Audio> findbymake(String make) {
        return repository.findbymake(make);
    }

    @Override
    public List<Audio> findbymodel(String model) {
        return repository.findbymodel(model);
    }

    @Override
    public List<Audio> findbywatts(String watts) {
        return repository.findbywatts(watts);
    }

    @Override
    public List<Audio> findbyamps(String amps) {
        return repository.findbyamps(amps);
    }

    @Override
    public Audio create(Audio entity) {
        return repository.save(entity);
    }

    @Override
    public Audio readById(String s) {
        return repository.findOne(s);
    }

    @Override
    public Set<Audio> readAll() {

        Set<Audio> result = new HashSet<Audio>();

        Iterator iterator = repository.findAll().iterator();
        while (iterator.hasNext()) {
            result.add((Audio) iterator.next());
        }
        return result;
    }

    @Override
    public Audio update(Audio entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Audio entity) {
        repository.delete(entity);
    }
}
