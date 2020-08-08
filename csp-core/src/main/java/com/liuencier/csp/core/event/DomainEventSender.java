package com.liuencier.csp.core.event;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-08 23:10
 **/
public interface DomainEventSender {
    void send(DomainEvent event);
}
