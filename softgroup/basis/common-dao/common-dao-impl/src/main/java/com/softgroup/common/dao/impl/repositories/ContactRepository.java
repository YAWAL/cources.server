package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ContactEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends PagingAndSortingRepository<ContactEntity, String >{

    ContactEntity findByName(String name);

    ContactEntity findByPhoneNumber(String phoneNumber);

}
