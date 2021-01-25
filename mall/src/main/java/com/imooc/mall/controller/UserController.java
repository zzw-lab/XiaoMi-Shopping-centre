package com.imooc.mall.controller;

import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.imooc.mall.consts.MallConst.CURRENT_USER;


//@RequestMapping("") 网站前缀
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    //        x-www-form-rulencoded方式/json格
    //json格式
    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid  @RequestBody UserRegisterForm userRegisterForm){
//        if(bindingResult.hasErrors()){
//            log.error("注册提交的参数有误，{}{}",
//                    Objects.requireNonNull(bindingResult.getFieldError()).getField(),
//                    bindingResult.getFieldError().getDefaultMessage());
//            return ResponseVo.error(PARAM_ERROR, bindingResult);
//        }

        User user=new User();
        BeanUtils.copyProperties(userRegisterForm,user);
        return iUserService.register(user);
        //x-www-form-rulencoded方式
//        public void register(User user){
//        public void register(@RequestParam(value = "username") String username){
//        log.info("username={}",username);
//        log.info("username={}",userForm.getUsername());
////        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
//        return ResponseVo.success();

    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  @ApiIgnore HttpSession httpSession){
//        if(bindingResult.hasErrors()){
//            log.error("注册提交的参数有误，{}{}",
//                    Objects.requireNonNull(bindingResult.getFieldError()).getField(),
//                    bindingResult.getFieldError().getDefaultMessage());
//            return ResponseVo.error(PARAM_ERROR, bindingResult);
//        }
        ResponseVo<User> userResponseVo = iUserService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        //设置Session
        //HttpSession session = httpServletRequest.getSession();
        httpSession.setAttribute(CURRENT_USER,userResponseVo.getData());
        log.info("/login sessionId={}",httpSession.getId());
        return userResponseVo;
    }

    //session保存在内存里，改进版：token+redis
    @GetMapping("/user")
    public ResponseVo<User> userInfo(@ApiIgnore HttpSession httpSession){
        log.info("/user sessionId={}",httpSession.getId());
        User user = (User)httpSession.getAttribute(CURRENT_USER);
        return ResponseVo.success(user);
    }

    //TODO 判断登录状态，拦截器

    /**
     * {@link org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory getSessionTimeoutInMinutes();}
     * @param httpSession
     * @return
     */
    @PostMapping("/user/logout")
    public ResponseVo logout(@ApiIgnore HttpSession httpSession){
        log.info("/user/logout sessionId={}",httpSession.getId());
        httpSession.removeAttribute(CURRENT_USER);
        return ResponseVo.success();
    }
}
