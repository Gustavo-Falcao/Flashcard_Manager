package org.flashCardManager.jsonRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.flashCardManager.model.entity.Identifiable;
import org.flashCardManager.repository.CrudRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractJsonRepository <T extends Identifiable> implements CrudRepository<T> {

    protected final String filePath;

    protected AbstractJsonRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<T> findAll() {
        return readFile();
    }

    @Override
    public Optional<T> findById(String id) {
        return readFile()
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    @Override
    public T save(T entity) {
        List<T> entities = readFile();
        entities.add(entity);
        writeFile(entities);
        return entity;
    }

    @Override
    public T update(T entity) {
        List<T> entities = readFile();

        for(int i = 0; i < entities.size(); i++) {
            if(entities.get(i).getId().equals(entity.getId())) {
                entities.set(i, entity);
                writeFile(entities);

                return  entity;
            }
        }
        throw new IllegalArgumentException("Entidade não encontrada.");
    }

    @Override
    public void deleteById(String id) {

        List<T> entities = readFile();

        boolean removed = entities.removeIf(
                entity -> entity.getId().equals(id)
        );

        if (!removed) {
            //mudar para exception especifica
            throw new IllegalArgumentException(
                    "Entidade não encontrada."
            );
        }

        writeFile(entities);
    }

    protected List<T> readFile() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        if(!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(file, new TypeReference<List<T>>() {});
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
            return new ArrayList<>();
        }
    }

    protected void writeFile(List<T> entities) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(file, entities);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo");
        }
    }
}
