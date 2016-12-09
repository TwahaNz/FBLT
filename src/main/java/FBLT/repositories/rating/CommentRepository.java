package FBLT.repositories.rating;

import FBLT.domain.rating.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Comment
 */

@RepositoryRestResource(collectionResourceRel = "comment", path = "comment")
public interface CommentRepository extends MongoRepository<Comment, String> {

}
