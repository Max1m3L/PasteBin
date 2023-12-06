package com.maxlvshv.pastebin.repository;

import com.maxlvshv.pastebin.entity.PostEntity;
import com.maxlvshv.pastebin.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findAll();
}
