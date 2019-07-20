package com.web.weblinkchecker.service;

import com.web.weblinkchecker.dto.ProjectDto;
import com.web.weblinkchecker.entity.ProjectEntity;
import com.web.weblinkchecker.exception.NotFoundByIdException;
import com.web.weblinkchecker.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectRepository projectReactiveRepository;
    private final ModelMapper mapper = new ModelMapper();

    public ProjectDto create(ProjectDto projectDto) {
        log.debug("Creating project ('{}')", projectDto);

        ProjectEntity projectEntity = mapper.map(projectDto, ProjectEntity.class);
        projectEntity = projectRepository.save(projectEntity);
        return mapper.map(projectEntity, ProjectDto.class);
    }

    public ProjectDto getById(String id) {
        log.debug("Getting project by id (id='{}')", id);

        return projectReactiveRepository.findById(id)
                .map(projectEntity -> mapper.map(projectEntity, ProjectDto.class))
                .orElseThrow(() -> new NotFoundByIdException(id, ProjectEntity.class));
    }

}
