package com.example.simple_chat.security;

import com.example.simple_chat.user.entity.Status;
import com.example.simple_chat.user.entity.User;
import com.example.simple_chat.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException {
        if (authentication != null && authentication.getName() != null) {
            String username = authentication.getName();
            User user = userService.findByUsername(username);
            if (user != null) {
                user.setStatus(Status.OFFLINE);
                userService.saveUser(user);
            }
        }

        // Redirect after logout
        response.sendRedirect("/login?logout");
    }
}