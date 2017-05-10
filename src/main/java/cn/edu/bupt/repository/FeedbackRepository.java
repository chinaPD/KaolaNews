package cn.edu.bupt.repository;

import cn.edu.bupt.domain.UserFeedBack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hadoop on 17-5-10.
 */
public interface FeedbackRepository extends CrudRepository<UserFeedBack, Long> {

    public UserFeedBack save(UserFeedBack feedBack);
}
