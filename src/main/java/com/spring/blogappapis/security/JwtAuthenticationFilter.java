package com.spring.blogappapis.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetails userDetails;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. get token
        String requestToken = request.getHeader("Authorization");

        //Bearer 2352523sdgsg
        log.info("RequestToken" + requestToken);
        String username = null;
        String token = null;

        if(request!=null && requestToken.startsWith("Bearer")){
            token = requestToken.substring(7);
            try {
                username = this.jwtTokenHelper.getUsernameFromToken(token);
            }catch (IllegalArgumentException){
                log.error("Unable to get Jwt token ");
            }
            catch (ExpiredJwtException){
                log.error("Jwt token has expired");
            }
            catch (MalformedJwtException){
                log.error("invalid jwt");
            }
        }else {
            log.info("Jwt token does not begin with Bearer");
        }
    }

}
