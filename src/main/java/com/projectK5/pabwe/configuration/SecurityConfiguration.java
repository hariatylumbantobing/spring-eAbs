package com.projectK5.pabwe.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;
 
 @Autowired
 private DataSource dataSource;
 
 private final String USERS_QUERY = "select uname, password, active from user where uname=?";
 private final String ROLES_QUERY = "select u.uname, r.role from user u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.uname=?";

 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.jdbcAuthentication()
   .usersByUsernameQuery(USERS_QUERY)
   .authoritiesByUsernameQuery(ROLES_QUERY)
   .dataSource(dataSource)
   .passwordEncoder(bCryptPasswordEncoder);
 }
 
 @Override
 protected void configure(HttpSecurity http) throws Exception{
  http.authorizeRequests()
   .antMatchers("/",
		   		"/static/**",
		   		"/documentation/**",
		   		"/bower_components/**",
		   		"/build/**",
		   		"/css/**",
		   		"/dist/**",
		   		"/fonts/**",
		   		"/js/**",
		   		"/vendor/**",
		   		"/plugins/**").permitAll()
   .antMatchers("/login").permitAll()
   .antMatchers("/signup").permitAll()
   .antMatchers("/pages/**").hasAuthority("ADMIN").anyRequest()
   .authenticated().and().csrf().disable()
   .formLogin().loginPage("/login").failureUrl("/login?error=true")
   .defaultSuccessUrl("/pages/dashboard")
   .usernameParameter("uname")
   .passwordParameter("password")
   .and().logout()
   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
   .logoutSuccessUrl("/")
   .and().rememberMe()
   .tokenRepository(persistentTokenRepository())
   .tokenValiditySeconds(60*60)
   .and().exceptionHandling().accessDeniedPage("/access_denied");

 }
 
 @Bean
 public PersistentTokenRepository persistentTokenRepository() {
  JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
  db.setDataSource(dataSource);
  
  return db;
 }
}