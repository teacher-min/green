package org.edu.demo1.api.user.application;

import org.edu.demo1.api.user.dto.request.UserAddRequestDTO;

public interface UserAddService {

    /**
     * 사용자 추가
     *
     * @param userAddRequestDTO UserAddRequestDTO
     */
    void addUser(UserAddRequestDTO userAddRequestDTO);

}
