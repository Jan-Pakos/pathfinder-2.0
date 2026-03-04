package com.example.pathfinder.domain.citycrud;

import org.springframework.stereotype.Service;

@Service
class NodeService {

    NodeAndConnectionRepository repository;

    public NodeService(NodeAndConnectionRepository repository) {
        this.repository = repository;
    }

    public Node save(Node node) {
        return repository.save(node);
    }

    public void remove(Long id) {
        repository.removeById(id);
    }
}
