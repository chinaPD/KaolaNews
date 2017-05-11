package cn.edu.bupt.repository;

import cn.edu.bupt.domain.Collection;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hadoop on 17-5-10.
 */
public interface CollectionRepository extends CrudRepository<Collection, Long> {

    List<Collection> findByUserId(long id);
    Collection save(Collection collection);
}
