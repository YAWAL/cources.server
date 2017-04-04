package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.MessageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MessageRepository extends PagingAndSortingRepository<MessageEntity, String> {

    List<MessageEntity> findBySenderId(String senderId);

    List<MessageEntity> findBySenderIdAndConversationId(String senderId, String conversationId);

}
