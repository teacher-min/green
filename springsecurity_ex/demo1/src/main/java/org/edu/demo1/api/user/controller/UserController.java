package org.edu.demo1.api.user.controller;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import org.edu.demo1.api.user.application.UserAddService;
import org.edu.demo1.api.user.application.UserDelService;
import org.edu.demo1.api.user.application.UserGetService;
import org.edu.demo1.api.user.dto.request.UserAddRequestDTO;
import org.edu.demo1.util.auth.AuthUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserGetService userGetService;

    private final UserAddService userAddService;

    private final UserDelService userDelService;

    @GetMapping("/regist")
    public String regist() {
        return "/user/regist";
    }

    @PostMapping("/regist-action")
    public void loginAction(@Valid UserAddRequestDTO userAddRequestDTO, HttpServletResponse response) throws IOException {
        // 사용자 정보 저장
        userAddService.addUser(userAddRequestDTO);

        // 회원가입 완료 후 사용자 로그인 화면으로 이동
        response.sendRedirect("/login-view");
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) throws AccessDeniedException {
        // 사용자 정보 조회
        model.addAttribute("userInfo", userGetService.getUserById(AuthUtil.getLoginId()));

        return "/user/dashboard";
    }

    @PostMapping("/delete")
    public void delete(HttpServletResponse response) throws IOException {
        // 사용자 정보 삭제
        userDelService.delUser(AuthUtil.getLoginId());

        // 삭제 완료 후 사용자 로그인 화면으로 이동
        response.sendRedirect("/login-view");
    }

}
