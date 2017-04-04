package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.util.ConversationType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by VYA on 04.04.2017.
 */
public interface ConversationRepository extends PagingAndSortingRepository<ConversationEntity, String > {

    List<ConversationEntity> findByName(String name);

    List<ConversationEntity> findByAdminId(String adminId);

    List<ConversationEntity> findByType(ConversationType type);
}
