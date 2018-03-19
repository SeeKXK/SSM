package com.seekxk.user.controller;

import com.seekxk.user.model.User;
import com.seekxk.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String goToLogin(){
        System.out.println("a");
        return "/test";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response,String username,String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);

        }catch (UnknownAccountException uae){// 捕获未知用户名异常
            return "error username";
        }catch (IncorrectCredentialsException ice){// 捕获密码错误异常
            return "error password";
        }catch (ExcessiveAttemptsException eae){// 捕获错误登录过多的异常
            return "error tooMuch";
        }
        User user = userService.selectByUserName(username);
        subject.getSession().setAttribute("user", user);
        return  "login success";
    }

    @RequestMapping("/getUser")
    public ModelAndView getUser(String name){
        User user=userService.selectByUserName(name);
        return new ModelAndView("/welcome","user",user);
    }

}
