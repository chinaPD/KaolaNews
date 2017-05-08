package cn.edu.bupt;

import cn.edu.bupt.authorization.MvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by hadoop on 17-5-3.
 */
@SpringBootApplication
public class KaolaNews {

    public static void main(String[] args) {
        Object[] sources = {KaolaNews.class, MvcConfig.class};
        SpringApplication.run(sources, args);
    }
}
