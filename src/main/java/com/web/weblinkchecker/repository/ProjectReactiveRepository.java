package com.web.weblinkchecker.repository;

import com.web.weblinkchecker.entity.ProjectEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectReactiveRepository extends ReactiveMongoRepository<ProjectEntity, String> {
}
