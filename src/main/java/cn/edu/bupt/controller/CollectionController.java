package cn.edu.bupt.controller;

import cn.edu.bupt.authorization.annotation.Authorization;
import cn.edu.bupt.authorization.annotation.CurrentUser;
import cn.edu.bupt.domain.Article;
import cn.edu.bupt.domain.User;
import cn.edu.bupt.domain.Collection;
import cn.edu.bupt.model.ResultModel;
import cn.edu.bupt.model.ResultStatus;
import cn.edu.bupt.repository.ArticleRepository;
import cn.edu.bupt.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 17-5-10.
 */

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    CollectionRepository repository;

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addCollection(@RequestBody Collection collections) {
        if (collections.getUserId() == 0 || collections.getArticleId() == 0) {
            return new ResponseEntity<ResultModel>(new ResultModel(ResultStatus.ADD_COLLECTION_FAILED),
                    HttpStatus.OK);
        }

        repository.save(collections);

        return new ResponseEntity<ResultModel>(new ResultModel(ResultStatus.ADD_COLLECTION_SUCCESS),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @Authorization
    public ResponseEntity getCollection(@CurrentUser User user) {
        List<Collection> collections = repository.findByUserId(user.getId());
        List<Article> articles = new ArrayList<>();
        for (Collection coll : collections) {
            articles.add(articleRepository.findById(coll.getArticleId()));
        }

        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }
}
