package com.maxlvshv.pastebin.repository;

import com.maxlvshv.pastebin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    UserEntity findByNickname(String nickname);
    Optional<UserEntity> findFirstByNickname(String name);

    List<UserEntity> findAll();
}
