package com.mytt.boot.Controller;

import com.mytt.boot.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
    public class LoginController {

    @Autowired
    private UserServiceImpl userServiceImpl;
        @RequestMapping("/login")
        public String gotologin(HttpServletRequest request){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                return "index";
            }
            return "login";
        }
        //登录成功后进入的地址
        @RequestMapping("/index")
        public String gotoindex(HttpServletRequest request){
            String yzm=request.getParameter("yzm");
            if (!yzm.equals("123456")){
                return "login";
            }
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
                request.getSession().setAttribute("authorities",authorities);
            }
            return "index";
        }
    }
