package com.sample.process.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.sample.process.domain.AppRequest;
import com.sample.process.exception.IdExistsException;
import com.sample.process.repository.AppRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class AppServiceImpl implements AppService {
    private final AppRepository repository;

    @Inject
    public AppServiceImpl(final AppRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public AppRequest save(@NotNull @Valid final AppRequest request) {
        AppRequest existing = repository.findOne(request.getMissionId());
        if (existing != null) {
            throw new IdExistsException(
                    String.format("Mission id :"+request.getMissionId()+" already exists"));
        }
        return repository.save(request);
    }
}
