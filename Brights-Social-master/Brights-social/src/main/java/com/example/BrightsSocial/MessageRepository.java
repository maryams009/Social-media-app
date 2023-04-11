package com.example.BrightsSocial;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query(value ="select * from message order by time desc", nativeQuery = true)
    List<Message> findAllMessages();

}
