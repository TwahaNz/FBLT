package FBLT.repositories.rating;

import FBLT.domain.rating.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "comment", path ="comment")
public interface CommentRepository extends MongoRepository<Comment,String> {

}
