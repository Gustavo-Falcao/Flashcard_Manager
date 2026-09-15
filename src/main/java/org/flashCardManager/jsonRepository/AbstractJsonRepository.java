package org.flashCardManager.jsonRepository;

import org.flashCardManager.repository.CrudRepository;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public abstract class AbstractJsonRepository <T> implements CrudRepository<T> {

    protected final Path filePath;

    protected AbstractJsonRepository(Path filePath) {
        this.filePath = filePath;
    }

    protected abstract String getId(T entity);

    protected abstract List<T> readFile();

    protected abstract void writeFile(List<T> entities);

    @Override
    public List<T> findAll() {
        return readFile();
    }

    @Override
    public Optional<T> findById(String id) {
        return readFile()
                .stream()
                .filter(entity -> getId(entity).equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(String id) {
        List<T> entities = readFile();

        entities.removeIf(
                entity -> getId(entity).equals(id)
        );

        writeFile(entities);
    }
}
