package com.web.weblinkchecker.repository;

import com.web.weblinkchecker.entity.ProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<ProjectEntity, String> {
}
