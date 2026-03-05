package com.example.pathfinder.domain.citycrud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConnectionService {

    private final ConnectionRepository repository;

    public Connection save(Connection connection) {
        return repository.save(connection);
    }
}
