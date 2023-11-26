package com.maxlvshv.pastebin.repository;

import com.maxlvshv.pastebin.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findAll();
}
