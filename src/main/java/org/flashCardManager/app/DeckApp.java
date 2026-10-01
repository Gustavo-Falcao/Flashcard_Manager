package org.flashCardManager.app;

import org.flashCardManager.controller.DeckController;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.deckDto.DeckRequestCreate;
import org.flashCardManager.model.dto.deckDto.DeckResponse;
import org.flashCardManager.view.DeckView;
import org.flashCardManager.view.ErrorDetailsView;
import org.flashCardManager.view.InputHelper;

import java.util.List;

public class DeckApp {

    private final DeckController deckController;
    private final CardApp cardApp;

    public DeckApp(DeckController deckController, CardApp cardApp) {
        this.deckController = deckController;
        this.cardApp = cardApp;
    }

    public void acoesDecks(String userId) {
        int opAcoesDecks;
        do {
            DeckView.mostrarAcoesDecks();
            opAcoesDecks = InputHelper.lerOpcaoInt("Escola uma acao: ");
            tratarAcoesDecks(userId, opAcoesDecks);
        } while (opAcoesDecks != 0);
    }

    private void tratarAcoesDecks(String userId, int opAcoesDecks) {
        switch (opAcoesDecks) {
            case 1 -> criarDeck(userId);
            case 2 -> mostrarDecksPorUsuario(userId);
            case 3 -> acessarDeck(userId);
            case 0 -> System.out.println("Voltando...");
            default -> System.out.println("Escolha uma opcao valida");
        }
    }

    private void criarDeck(String userId) {
        String name = InputHelper.lerString("Informe um nome ao deck: ");

        Result<DeckResponse> result = deckController.create(new DeckRequestCreate(userId, name));

        if(!result.success()) {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void mostrarDecksPorUsuario(String userId) {
        Result<List<DeckResponse>> result = deckController.getByUserId(userId);

        if(result.success()) {
            DeckView.mostrarDecksPorUsuario(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void acessarDeck(String userId) {
        mostrarDecksPorUsuario(userId);

        String idDeck = InputHelper.lerString("Informe o id do deck escolhido: ");

        Result<DeckResponse> result = deckController.findById(idDeck);

        if(result.success()) {
            mostrarAcoesDeck(result.data());
        } else  {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void mostrarAcoesDeck(DeckResponse deckResponse) {
        int opAcoesDeck;
        do {
            DeckView.mostrarDeck(deckResponse);
            DeckView.mostrarAcoesDeck();
            opAcoesDeck = InputHelper.lerOpcaoInt("Escolha uma acao: ");
            tratarOpAcoesDeck(deckResponse, opAcoesDeck);
        } while (opAcoesDeck != 0);
    }

    private void tratarOpAcoesDeck(DeckResponse deckResponse, int opAcoesDeck) {
        switch (opAcoesDeck) {
            case 1 -> System.out.println("Atualizar dados");
            case 2 -> cardApp.acoesCard(deckResponse.id());
            case 0 -> System.out.println("Voltando...");
            default -> System.out.println("Escolha uma opcao valida");
        }
    }

}
