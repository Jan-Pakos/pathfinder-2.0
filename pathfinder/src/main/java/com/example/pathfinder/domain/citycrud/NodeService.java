package com.example.pathfinder.domain.citycrud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NodeService {

    NodeAndConnectionRepository repository;

    public Node save(Node node) {
        return repository.save(node);
    }

    public void remove(Long id) {
        repository.removeById(id);
    }

    public Node updateNodeName(Long id, String s) {
        Node node = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Node not found"));
        node.setName(s);
        return repository.save(node);
    }
}
