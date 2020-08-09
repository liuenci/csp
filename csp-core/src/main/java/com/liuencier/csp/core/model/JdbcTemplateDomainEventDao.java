package com.liuencier.csp.core.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuencier.csp.core.event.DomainEvent;
import com.liuencier.csp.core.event.DomainEventDao;
import com.liuencier.csp.core.utils.JsonUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;
import java.util.function.Function;

import static com.google.common.collect.ImmutableMap.of;
import static com.google.common.collect.Maps.newHashMap;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-08 22:57
 **/
public class JdbcTemplateDomainEventDao implements DomainEventDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcTemplateDomainEventDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(List<DomainEvent> events) {
        String sql = "INSERT INTO DOMAIN_EVENT (ID, JSON_CONTENT) VALUES (:id, :json);";

        SqlParameterSource[] parameters = events.stream()
                .map((Function<DomainEvent, SqlParameterSource>) domainEvent ->
                        new MapSqlParameterSource()
                                .addValue("id", domainEvent.get_id())
                                .addValue("json", JsonUtils.obj2String(domainEvent)))
                .toArray(SqlParameterSource[]::new);

        jdbcTemplate.batchUpdate(sql, parameters);
    }

    @Override
    public void delete(String eventId) {
        String sql = "DELETE FROM DOMAIN_EVENT WHERE ID = :id;";
        jdbcTemplate.update(sql, of("id", eventId));
    }

    @Override
    public DomainEvent get(String eventId) {
        String sql = "SELECT JSON_CONTENT FROM DOMAIN_EVENT WHERE ID = :id;";
        return null;
    }

    @Override
    public List<DomainEvent> nextPublishBatch(int size) {
        String sql = "SELECT JSON_CONTENT FROM DOMAIN_EVENT WHERE STATUS != 'FAILED' ORDER BY CREATED_AT LIMIT :limit;";
        return null;
    }

    @Override
    public void markAsPublished(String eventId) {
        delete(eventId);
    }

    @Override
    public void markAsPublishFailed(String eventId) {
        String sql = "UPDATE DOMAIN_EVENT SET STATUS = 'FAILED' WHERE ID = :id;";
        jdbcTemplate.update(sql, of("id", eventId));
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM DOMAIN_EVENT;";
        jdbcTemplate.update(sql, newHashMap());
    }

    private RowMapper<DomainEvent> eventMapper(ObjectMapper objectMapper) {
        RowMapper<DomainEvent> content = (rs, rowNum) -> {
            try {
                return objectMapper.readValue(rs.getString("JSON_CONTENT"), DomainEvent.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        };
        return content;
    }
}
