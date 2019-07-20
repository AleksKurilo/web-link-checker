package com.web.weblinkchecker.repository;

import com.web.weblinkchecker.entity.LinkEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends MongoRepository<LinkEntity, String> {
}
