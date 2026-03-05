package com.example.pathfinder.domain.citycrud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CityCrudFacade {

    private final NodeService nodeService;
    private final ConnectionService connectionService;


    public Node addNode(Node node) {
        return nodeService.save(node);
    }

    public void removeNode(Long id) {
        nodeService.remove(id);
    }

    public Node updateNodeName(Long id, String s) {
        return nodeService.updateNodeName(id, s);
    }

    public Connection addConnection(Long fromNodeId, Long toNodeId, Long duration, TransportType transportType) {

        Node fromNode = nodeService.findById(fromNodeId);
        Node toNode = nodeService.findById(toNodeId);

        Connection connectionToAdd = Connection.builder()
                .fromNode(fromNode)
                .toNode(toNode)
                .duration(duration)
                .transportType(transportType)
                .build();
        return connectionService.save(connectionToAdd);
    }
}
