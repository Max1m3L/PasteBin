package com.maxlvshv.pastebin.repository;

import com.maxlvshv.pastebin.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findAll();

    @Query("SELECT p.title, p.subtitle, u.nickname FROM PostEntity p INNER JOIN p.user u")
    List<Object> findAllWithUsers();
}
