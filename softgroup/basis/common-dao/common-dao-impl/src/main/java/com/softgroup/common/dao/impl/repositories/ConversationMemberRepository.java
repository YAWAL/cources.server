package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by VYA on 04.04.2017.
 */
public interface ConversationMemberRepository extends PagingAndSortingRepository<ConversationMemberEntity, String > {

    List<ConversationMemberEntity> findByProfileId(String profileId);

    List<ConversationMemberEntity> findByConversationId(String conversationId);

    List<ConversationMemberEntity> findByConversationIdAndProfileId(String conversationId,String profileId);
}
