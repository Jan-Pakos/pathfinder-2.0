package com.example.pathfinder.domain.citycrud;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "fromNode", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Connection> outgoingConnections = new HashSet<>();

    @OneToMany(mappedBy = "toNode", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Connection> incomingConnections = new HashSet<>();

    public void addConnection(Node destination, Double distance) {
        Connection connection = new Connection();
        connection.setFromNode(this);
        connection.setToNode(destination);
        connection.setDistance(distance);
        this.outgoingConnections.add(connection);
    }

}
