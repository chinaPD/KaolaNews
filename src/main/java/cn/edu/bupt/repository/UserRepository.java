package cn.edu.bupt.repository;


import cn.edu.bupt.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by PD on 2017/5/3.
 */

public interface UserRepository extends CrudRepository<User, Long> {

    User save(User user);
    User findByUsername(String username);
    User findById(Long id);
}
