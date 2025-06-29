package com.example.simple_chat.security;

import com.example.simple_chat.user.entity.Status;
import com.example.simple_chat.user.entity.User;
import com.example.simple_chat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        user.setStatus(Status.ONLINE);
        userService.saveUser(user);

        // Redirect to index or chat page
        response.sendRedirect("/");
    }
}
