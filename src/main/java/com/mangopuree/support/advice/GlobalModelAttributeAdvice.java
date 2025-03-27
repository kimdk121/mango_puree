package com.mangopuree.support.advice;


import com.mangopuree.menu.service.MenuService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalModelAttributeAdvice {

    private final MenuService menuService;

    @ModelAttribute
    public void addCurrentMenu(HttpServletRequest request, Model model) {
        if (MediaType.APPLICATION_JSON_VALUE.equals(request.getHeader("Accept"))) {
            return;
        }

        String uri = request.getRequestURI();
        if (!uri.startsWith("/admin")) {
            return;
        }

        model.addAttribute("currentMenu", menuService.getCurrentMenuByUrl(uri));
    }
}
