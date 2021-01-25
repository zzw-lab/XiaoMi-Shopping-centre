package com.imooc.mall.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    /**
     * true 表示继续流程， false 表示中断
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("preHand...");
//        request.getSession();
//        User user = (User)request.getSession().getAttribute(CURRENT_USER);
//        if(user == null){
//            log.info("user=null");
//            throw new UserLoginException();
////            return false;
////            return ResponseVo.error(NEED_LOGIN);
//        }
        return true;
    }
}
