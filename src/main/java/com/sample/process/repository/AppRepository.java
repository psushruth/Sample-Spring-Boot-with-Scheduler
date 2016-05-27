package com.sample.process.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.process.domain.AppRequest;

public interface AppRepository extends JpaRepository<AppRequest, String> {
}
