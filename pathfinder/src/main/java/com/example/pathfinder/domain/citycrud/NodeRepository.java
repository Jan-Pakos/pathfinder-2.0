package com.example.pathfinder.domain.citycrud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends CrudRepository<Node, Long> {
    void removeById(Long id);
}
