package com.toffee.nuts.bulletinboard.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.concurrent.atomic.AtomicLong;

@Entity
public class Comment {

    @Id @GeneratedValue
    public AtomicLong id;
}
