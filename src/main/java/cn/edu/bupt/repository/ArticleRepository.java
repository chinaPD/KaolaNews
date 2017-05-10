package cn.edu.bupt.repository;

import cn.edu.bupt.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hadoop on 17-5-8.
 */
public interface ArticleRepository extends CrudRepository<Article, Long>{
    List<Article> findByTypelabel(String typelabel);
    Article findById(long id);
}
