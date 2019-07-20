package com.web.weblinkchecker.confuguration;

import com.web.weblinkchecker.entity.LinkEntity;
import com.web.weblinkchecker.entity.ProjectEntity;
import com.web.weblinkchecker.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectEntityMongoEventListener extends AbstractMongoEventListener<ProjectEntity> {

    private final LinkRepository linkRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<ProjectEntity> event) {
        log.debug("Creating links by project (id='{}')", event.getSource().getId());

        ProjectEntity projectEntity = event.getSource();
        final Set<LinkEntity> links = new HashSet<>(linkRepository.saveAll(projectEntity.getLinks()));
        projectEntity.setLinks(links);
    }

}
