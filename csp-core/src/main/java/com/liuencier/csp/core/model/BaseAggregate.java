package com.liuencier.csp.core.model;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-08 22:40
 **/
public abstract class BaseAggregate {
    private List<DomainEvent> _events;

    protected final void raiseEvent(DomainEvent event) {
        get_events().add(event);
    }

    final void clearEvents() {
        get_events().clear();
    }

    final List<DomainEvent> get_events() {
        if (_events == null) {
            _events = newArrayList();
        }
        return _events;
    }
}
