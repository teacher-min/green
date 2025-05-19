package org.edu.demo1.config.security.provider;

import java.util.Collections;

import org.edu.demo1.api.login.exception.LoginException;
import org.edu.demo1.api.login.exception.LoginExceptionResult;
import org.edu.demo1.api.user.application.UserGetService;
import org.edu.demo1.api.user.dto.response.UserGetResponseDTO;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserGetService userGetService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        // 사용자 정보 조회
        UserGetResponseDTO userInfo = userGetService.getUserByUserId(username);

        // password 일치 여부 체크
        if(!bCryptPasswordEncoder.matches(password, userInfo.password()))
            throw new LoginException(LoginExceptionResult.NOT_CORRECT);

        // return UsernamePasswordAuthenticationToken
        return new UsernamePasswordAuthenticationToken(
                userInfo.id(),
                userInfo.password(),
                Collections.singleton(new SimpleGrantedAuthority(userInfo.roleName().name()))
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
