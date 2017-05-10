package cn.edu.bupt.controller;

import cn.edu.bupt.domain.UserFeedBack;
import cn.edu.bupt.model.ResultModel;
import cn.edu.bupt.model.ResultStatus;
import cn.edu.bupt.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hadoop on 17-5-10.
 */

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository repository;

    @RequestMapping("")
    public ResponseEntity userFeedBack(UserFeedBack feedBack) {
        if (feedBack.getContent().length() <= 5) {
            return new ResponseEntity<ResultModel>(
                    new ResultModel(ResultStatus.CONTENT_NOT_OK), HttpStatus.OK);
        }
        repository.save(feedBack);

        return new ResponseEntity<ResultModel>(
                new ResultModel(ResultStatus.SUCCESS), HttpStatus.OK);
    }
}
