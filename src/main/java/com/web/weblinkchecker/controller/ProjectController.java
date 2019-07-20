package com.web.weblinkchecker.controller;

import com.web.weblinkchecker.dto.ProjectDto;
import com.web.weblinkchecker.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDto create(@RequestBody @Valid ProjectDto projectDto) {
        log.info("Request: Create project ('{}')", projectDto);

        return projectService.create(projectDto);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public ProjectDto getById(@PathVariable String id) {
        log.info("Request: Get project by id (id='{}')", id);

        return projectService.getById(id);
    }
}
