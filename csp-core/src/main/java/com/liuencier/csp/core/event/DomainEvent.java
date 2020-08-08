package com.liuencier.csp.core.event;

import com.liuencier.csp.core.utils.UuidGenerator;
import lombok.Getter;

import java.time.Instant;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-08 22:40
 **/
@Getter
public abstract class DomainEvent {
    private String _id = UuidGenerator.newUuid();
    private Instant _createdAt = Instant.now();

    @Override
    public String toString() {
        return "DomainEvent{" +
                "_id='" + _id + '\'' +
                ", _createdAt=" + _createdAt +
                '}';
    }
}
