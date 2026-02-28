package domain.citycrud;

import org.springframework.stereotype.Service;

@Service
class NodeService {

    NodeAndConnectionRepository repository;

    public NodeService(NodeAndConnectionRepository repository) {
        this.repository = repository;
    }
}
