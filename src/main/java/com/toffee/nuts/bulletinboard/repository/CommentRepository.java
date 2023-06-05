package com.toffee.nuts.bulletinboard.repository;

import com.toffee.nuts.bulletinboard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.concurrent.atomic.AtomicLong;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
