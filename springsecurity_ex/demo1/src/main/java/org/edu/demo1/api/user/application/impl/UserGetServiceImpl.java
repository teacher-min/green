package org.edu.demo1.api.user.application.impl;

import org.edu.demo1.api.user.application.UserGetService;
import org.edu.demo1.api.user.domain.repository.UserRepository;
import org.edu.demo1.api.user.dto.response.UserGetResponseDTO;
import org.edu.demo1.api.user.exception.UserException;
import org.edu.demo1.api.user.exception.UserExceptionResult;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserGetServiceImpl implements UserGetService {

    private final UserRepository userRepository;

    /**
     * 사용자 idx를 이용해 사용자 정보 조회
     *
     * @param id 사용자 idx
     * @return 사용자 정보 UserGetResponseDTO
     */
    @Override
    public UserGetResponseDTO getUserById(final long id) {
        return userRepository.findById(id)
                .map(UserGetResponseDTO::of)
                .orElseThrow(() -> new UserException(UserExceptionResult.NOT_EXISTS));
    }

    /**
     * 사용자 id를 이용해 사용자 정보 조회
     *
     * @param userId 사용자 id
     * @return 사용자 정보 UserGetResponseDTO
     */
    @Override
    public UserGetResponseDTO getUserByUserId(final String userId) {
        return userRepository.findByLoginInfoUserId(userId)
                .map(UserGetResponseDTO::of)
                .orElseThrow(() -> new UserException(UserExceptionResult.NOT_EXISTS));
    }
    
}
