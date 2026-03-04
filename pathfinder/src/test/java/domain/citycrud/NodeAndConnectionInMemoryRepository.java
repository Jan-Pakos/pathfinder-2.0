package domain.citycrud;

import com.example.pathfinder.citycrud.Node;
import com.example.pathfinder.citycrud.NodeAndConnectionRepository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

class NodeAndConnectionInMemoryRepository implements NodeAndConnectionRepository {

    private final ConcurrentHashMap<Long, Node> db;
    private final AtomicLong counter;

    public NodeAndConnectionInMemoryRepository() {
        this.db = new ConcurrentHashMap<>();
        this.counter = new AtomicLong(0);
    }

    @Override
    public <S extends Node> S save(S entity) {
        if (entity.getId() == null) {
            long id = counter.incrementAndGet();
            entity.setId(id);
        }

        db.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends Node> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Node> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Node> findAll() {
        return null;
    }

    @Override
    public Iterable<Node> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Node entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Node> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void removeById(Long id) {
        db.remove(id);
    }
}
