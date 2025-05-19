package com.jdh.springSecuritySession.util.auth;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.nio.file.AccessDeniedException;

/**
 * Authentication Util Class
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthUtil {

    /**
     * Spring Security Context에서 로그인한 사용자의 id 조회
     *
     * @return 로그인한 사용자의 id
     * @throws AccessDeniedException AccessDeniedException
     */
    public static long getLoginId() throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 정상적으로 로그인한 사용자 정보인지 체크
        checkAuth(authentication);

        return (long) authentication.getPrincipal();
    }

    /**
     * 정상적으로 로그인한 사용자 정보인지 체크
     *
     * @param authentication Authentication
     * @throws AccessDeniedException AccessDeniedException
     */
    private static void checkAuth(Authentication authentication) throws AccessDeniedException {
        if(authentication == null || !authentication.isAuthenticated()) {
            throw new AccessDeniedException("로그인 정보가 존재하지 않습니다.");
        }
    }

}
