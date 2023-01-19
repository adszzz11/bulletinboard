package com.toffee.nuts.bulletinboard.repository;

import com.toffee.nuts.bulletinboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BoardRepository extends JpaRepository<Board, Long> {
}
