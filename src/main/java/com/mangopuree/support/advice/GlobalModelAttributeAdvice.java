package com.mangopuree.support.advice;


import com.mangopuree.menu.service.MenuService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalModelAttributeAdvice {

    private final MenuService menuService;

    /**
     * 현재 메뉴 model에 저장
     * @param request
     * @param model
     */
    @ModelAttribute
    public void addCurrentMenu(HttpServletRequest request, Model model) {
        String uri = request.getRequestURI();
        if (!uri.startsWith("/admin")) {
            return;
        }

        model.addAttribute("currentMenu", menuService.getCurrentMenuByUrl(uri));
    }
}
