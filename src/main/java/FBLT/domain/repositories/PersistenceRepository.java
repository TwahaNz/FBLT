package FBLT.domain.repositories;

import FBLT.domain.PersistenceTestClass;
import com.google.gson.Gson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "test-persistence", path ="test-persistence")
public interface PersistenceRepository extends MongoRepository<PersistenceTestClass, String>{
    List<PersistenceTestClass> findByName(@Param("name") String name);
}


