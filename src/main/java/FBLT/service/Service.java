package FBLT.service;

import java.util.Set;

/**
 * Created by maybra01 on 10/12/2016.
 */
public interface Service <E,ID>{
    E create(E entity);

    E readById(ID id);

    Set<E> readAll();

    E update(E entity);

    void delete(E entity);

}
