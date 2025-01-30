package com.varunvilva.blog.repository;

import com.varunvilva.blog.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {

}
