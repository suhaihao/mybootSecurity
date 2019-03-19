package com.mytt.boot.Config;

import com.mytt.boot.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //主要的配置放发
        http.authorizeRequests()
                //配置放开静态资源
                .antMatchers("/h-ui/**").permitAll()
                .antMatchers("/h-ui.admin/**").permitAll()
                .antMatchers("/lib/**").permitAll()
                .anyRequest().authenticated()
                //配置登录请求以及登录后地址
                .and().formLogin().loginPage("/login").successForwardUrl("/index")
                //配置错误提示信息
                .failureUrl("/login?error=true").permitAll()
                //设置自动登录时间一个星期
                .and().rememberMe().tokenRepository(persistentTokenRepository()).tokenValiditySeconds(60 * 60 * 24 * 7).userDetailsService(userServiceImpl)
                //配置session过期后访问地址
                //.and().sessionManagement().invalidSessionUrl("/login")
                //配置登出后的访问地址
                .and().logout().deleteCookies("JSESSIONID").logoutSuccessUrl("/login?logout=true").permitAll().invalidateHttpSession(true)
                //配置无权限访问页面
                .and().exceptionHandling().accessDeniedPage("/403").and()
                //关闭csrf攻击保护
                .csrf().disable();
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
}
