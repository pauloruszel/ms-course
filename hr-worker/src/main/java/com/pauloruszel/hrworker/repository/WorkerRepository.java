package com.pauloruszel.hrworker.repository;

import com.pauloruszel.hrworker.domain.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
