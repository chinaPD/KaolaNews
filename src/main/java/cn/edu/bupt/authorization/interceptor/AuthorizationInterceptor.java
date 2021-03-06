package cn.edu.bupt.authorization.interceptor;

import cn.edu.bupt.authorization.annotation.Authorization;
import cn.edu.bupt.authorization.manager.TokenManager;
import cn.edu.bupt.authorization.model.TokenModel;
import cn.edu.bupt.config.Constants;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by hadoop on 17-5-3.
 */

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenManager manager;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();

        if (method.getAnnotation(Authorization.class) == null) {
            return true;
        }

        //从header中得到token
        String authorization = request.getHeader(Constants.AUTHORIZATION);
        System.out.println(Constants.AUTHORIZATION + ":  " + authorization);

        TokenModel model = manager.getToken(authorization);
        System.out.println(model);

        if (manager.checkToken(model)) {
            //如果token验证成功，将token对应的用户id存在request中，便于之后注入
            request.setAttribute(Constants.CURRENT_USER_ID, model.getUserId());
            return true;
        }

        //如果验证token失败，并且方法注明了Authorization，返回401错误
  /*      if (method.getAnnotation(Authorization.class) != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }*/

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

}
