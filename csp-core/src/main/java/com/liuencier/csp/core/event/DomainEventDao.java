package com.liuencier.csp.core.event;

import com.liuencier.csp.core.event.DomainEvent;

import java.util.List;
// 这个DAO可以根据自己的业务来定义
public interface DomainEventDao {
    void save(List<DomainEvent> events);

    void delete(String eventId);

    DomainEvent get(String eventId);

    List<DomainEvent> nextPublishBatch(int size);

    void markAsPublished(String eventId);

    void markAsPublishFailed(String eventId);

    void deleteAll();
}
