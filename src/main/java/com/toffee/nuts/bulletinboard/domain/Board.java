package com.toffee.nuts.bulletinboard.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Board {

    @Id @GeneratedValue
    private Long id;
}
