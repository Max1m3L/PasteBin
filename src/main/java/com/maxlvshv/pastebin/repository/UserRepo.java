package com.maxlvshv.pastebin.repository;

import com.maxlvshv.pastebin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByNickname(String nickname);

    List<UserEntity> findAll();
}
