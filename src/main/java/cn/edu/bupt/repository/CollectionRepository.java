package cn.edu.bupt.repository;

import cn.edu.bupt.domain.User;
import cn.edu.bupt.domain.UserCollections;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hadoop on 17-5-10.
 */
public interface CollectionRepository extends CrudRepository<UserCollections, Long> {

    List<UserCollections> findByUserId(long id);
    UserCollections save(UserCollections collection);
}
