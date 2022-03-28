package com.j2kb.valueup.repository;

import com.j2kb.valueup.domain.Comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
