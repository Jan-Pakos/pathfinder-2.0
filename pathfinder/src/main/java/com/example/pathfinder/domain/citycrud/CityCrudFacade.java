package com.example.pathfinder.domain.citycrud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CityCrudFacade {

    private final NodeService nodeService;


    public Node addNode(Node node) {
        return nodeService.save(node);
    }

    public void removeNode(Long id) {
        nodeService.remove(id);
    }

    public Node updateNodeName(Long id, String s) {
        return nodeService.updateNodeName(id, s);
    }
}
