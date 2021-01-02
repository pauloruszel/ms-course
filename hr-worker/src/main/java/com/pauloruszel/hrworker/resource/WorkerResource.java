package com.pauloruszel.hrworker.resource;

import com.pauloruszel.hrworker.domain.model.Worker;
import com.pauloruszel.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> retorno = workerRepository.findAll();
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        Optional<Worker> retorno = workerRepository.findById(id);
        return retorno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
