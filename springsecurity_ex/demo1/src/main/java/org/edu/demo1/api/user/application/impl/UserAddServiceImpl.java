package org.edu.demo1.api.user.application.impl;

import org.edu.demo1.api.user.application.UserAddService;
import org.edu.demo1.api.user.domain.entity.User;
import org.edu.demo1.api.user.domain.repository.UserRepository;
import org.edu.demo1.api.user.dto.request.UserAddRequestDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserAddServiceImpl implements UserAddService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 사용자 추가
     *
     * @param userAddRequestDTO UserAddRequestDTO
     */
    @Override
    @Transactional
    public void addUser(UserAddRequestDTO userAddRequestDTO) {
        // User DTO to Entity
        User user = User.of(userAddRequestDTO);

        // password 암호화
        user.getLoginInfo().encryptPassword(bCryptPasswordEncoder);

        // save
        userRepository.save(user);
    }
    
}
