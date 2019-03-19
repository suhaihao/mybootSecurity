package com.mytt.boot.Service;

import com.mytt.boot.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public List<com.mytt.boot.Moudel.User> getAllmyuser() {
        return userDao.getAlluser();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据名字查出用户信息不为空继续为空抛出异常new UsernameNotFoundException(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //查出对应用户的角色
        authorities.add(new SimpleGrantedAuthority("admin"));
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        return new User("admin",encoder.encode("123456"), authorities);
    }
}
