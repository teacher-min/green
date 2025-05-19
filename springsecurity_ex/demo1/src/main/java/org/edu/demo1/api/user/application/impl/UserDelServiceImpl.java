package org.edu.demo1.api.user.application.impl;

import org.edu.demo1.api.user.application.UserDelService;
import org.edu.demo1.api.user.domain.entity.User;
import org.edu.demo1.api.user.domain.repository.UserRepository;
import org.edu.demo1.api.user.exception.UserException;
import org.edu.demo1.api.user.exception.UserExceptionResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDelServiceImpl implements UserDelService {

    private final UserRepository userRepository;

    /**
     * 사용자 삭제
     *
     * @param id 사용자 idx
     */
    @Override
    @Transactional
    public void delUser(final long id) {
        // 사용자 정보 조회
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException(UserExceptionResult.NOT_EXISTS));

        // delete
        userRepository.delete(user);
    }
    
}
