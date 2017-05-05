package cn.edu.bupt.authorization.manager.impl;

import cn.edu.bupt.authorization.manager.TokenManager;
import cn.edu.bupt.authorization.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by hadoop on 17-5-3.
 */
@Component
public class RedisTokenManager implements TokenManager {

    @Autowired
    private RedisTemplate<Long, String> redis;

  /*  @Autowired
    public void setRedis (RedisTemplate redis) {
        this.redis = redis;
        // 泛型设置成 Long 后必须更改对应的序列化方案
        redis.setKeySerializer (new JdkSerializationRedisSerializer());
    }*/

    public TokenModel createToken (long userId) {
        // 使用 uuid 作为源 token
        String token = UUID.randomUUID ().toString ().replace ("-", "");
        TokenModel model = new TokenModel (userId, token);
        // 存储到 redis 并设置过期时间
        redis.boundValueOps (userId).set (token, 72, TimeUnit.HOURS);
        return model;
    }
    public TokenModel getToken (String authentication) {
        if (authentication == null || authentication.length () == 0) {
            return null;
        }
        String [] param = authentication.split ("_");
        if (param.length != 2) {
            return null;
        }
        // 使用 userId 和源 token 简单拼接成的 token，可以增加加密措施
        long userId = Long.parseLong (param [0]);
        String token = param [1];
        return new TokenModel (userId, token);
    }

    public boolean checkToken (TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = (String) redis.boundValueOps (model.getUserId ()).get();
        if (token == null || !token.equals (model.getToken ())) {
            return false;
        }
        // 如果验证成功，说明此用户进行了一次有效操作，延长 token 的过期时间
        redis.boundValueOps (model.getUserId ()).expire (72, TimeUnit.HOURS);
        return true;
    }
    public void deleteToken (long userId) {
        redis.delete (userId);
    }
}
