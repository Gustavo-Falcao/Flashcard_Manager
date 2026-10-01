package org.flashCardManager.app;

import org.flashCardManager.controller.CardController;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.cardDto.CardRequestCreate;
import org.flashCardManager.model.dto.cardDto.CardRequestResponse;
import org.flashCardManager.model.entity.Context;
import org.flashCardManager.view.CardView;
import org.flashCardManager.view.ErrorDetailsView;
import org.flashCardManager.view.InputHelper;

import java.util.List;

public class CardApp {

    private final CardController cardController;
    private final MeaningApp meaningApp;

    public CardApp(CardController cardController, MeaningApp meaningApp) {
        this.cardController = cardController;
        this.meaningApp = meaningApp;
    }

    public void acoesCard(String deckId) {
        int opAcoesCard;

        do {
            CardView.mostrarAcoesCards();
            opAcoesCard = InputHelper.lerOpcaoInt("Escolha uma acao: ");
            tratarAcoesCards(opAcoesCard, deckId);
        } while (opAcoesCard != 0);
    }

    private void tratarAcoesCards(int opAcoesCard, String deckId) {
        switch (opAcoesCard) {
            case 1 -> criarCard(deckId);
            case 2 -> mostrarCardsPorDeck(deckId);
            case 3 -> acessarCard(deckId);
            case 0 -> System.out.println("Voltando...");
        }
    }

    private void criarCard(String deckId) {
        String name = InputHelper.lerString("Informe um nome para o card: ");
        Context context = Context.valueOf(InputHelper.lerString("Informe um context: "));
        String synonym = InputHelper.lerString("Informe um sinonimo: ");
        String phonetic = InputHelper.lerString("Informe a phonetica da palavra: ");

        Result<CardRequestResponse> result = cardController.create(new CardRequestCreate(deckId, name, context, synonym, phonetic));

        if(!result.success()) {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void mostrarCardsPorDeck(String deckId) {
        Result<List<CardRequestResponse>> result = cardController.getByDeckId(deckId);

        if(result.success()) {
            CardView.mostrarCardsPorDeck(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void acessarCard(String deckId) {
        mostrarCardsPorDeck(deckId);

        String idCard = InputHelper.lerString("Informe o id do card escolhido: ");

        Result<CardRequestResponse> result = cardController.findById(idCard);

        if(result.success()) {
            mostrarAcoesCard(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void mostrarAcoesCard(CardRequestResponse cardRequestResponse) {
        int opAcoesCard;

        do {
            CardView.mostrarCard(cardRequestResponse);
            CardView.mostrarAcoesCard();
            opAcoesCard = InputHelper.lerOpcaoInt("Escolha uma acao: ");
            tratarOpAcoesCard(cardRequestResponse, opAcoesCard);
        } while (opAcoesCard != 0);
    }

    private void tratarOpAcoesCard(CardRequestResponse cardRequestResponse, int opAcoesCard) {
        switch (opAcoesCard) {
            case 1 -> System.out.println("Atualizar dados");
            case 2 -> meaningApp.acoesMeanings(cardRequestResponse.id());
            case 0 -> System.out.println("Voltando...");
            default -> System.out.println("Escolha uma opcao valida");
        }
    }




}
