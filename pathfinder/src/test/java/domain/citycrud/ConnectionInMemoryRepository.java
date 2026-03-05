package domain.citycrud;

import com.example.pathfinder.domain.citycrud.Connection;
import com.example.pathfinder.domain.citycrud.ConnectionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

class ConnectionInMemoryRepository implements ConnectionRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Connection> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Connection> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Connection> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Connection getOne(Long aLong) {
        return null;
    }

    @Override
    public Connection getById(Long aLong) {
        return null;
    }

    @Override
    public Connection getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Connection> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Connection> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Connection> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Connection> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Connection> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Connection> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Connection, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Connection> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Connection> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Connection> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Connection> findAll() {
        return List.of();
    }

    @Override
    public List<Connection> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Connection entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Connection> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Connection> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Connection> findAll(Pageable pageable) {
        return null;
    }
}
