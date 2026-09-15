package org.flashCardManager.service;

import org.flashCardManager.repository.DeckRepository;

public class DeckService {
    private final DeckRepository repository;

    public DeckService(DeckRepository repository) {
        this.repository = repository;
    }

    public void teste() {

    }

    //metodos do crud repository
    /*
    void save(T entity);
    Optional<T> findById(String id);
    List<T> findAll();
    void update(T entity);
    void deleteById(String id);
    * */

    //metodos do deck repository
    //List<Deck> findByUserId(String userId);
    // como o deck repository é uma extensao da interface crud repository
    // ele tem o metodo dele e todos os métodos presentes no crud repository
}
