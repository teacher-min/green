package org.edu.demo1.api.user.domain.repository;

import java.util.Optional;

import org.edu.demo1.api.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 사용자 id를 이용해 사용자 정보 조회
     *
     * @param userId 사용자 id
     * @return Optional User
     */
    Optional<User> findByLoginInfoUserId(String userId);

}
