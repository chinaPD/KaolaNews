package cn.edu.bupt.controller;

import cn.edu.bupt.authorization.annotation.Authorization;
import cn.edu.bupt.authorization.annotation.CurrentUser;
import cn.edu.bupt.domain.Article;
import cn.edu.bupt.domain.User;
import cn.edu.bupt.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hadoop on 17-5-8.
 */

@RestController
@RequestMapping("/news")
public class RequestNews {

    @Autowired
    private ArticleRepository repository;

    @RequestMapping(value = "/recommend", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @Authorization
    public ResponseEntity<List<Article>> PersonalizedRecommendation(@CurrentUser User user) {
        List<Article> list = repository.findByTypelabel("war");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
