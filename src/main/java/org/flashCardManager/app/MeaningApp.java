package org.flashCardManager.app;

import org.flashCardManager.controller.MeaningController;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.meaningDto.MeaningRequestCreate;
import org.flashCardManager.model.dto.meaningDto.MeaningRequestResponse;
import org.flashCardManager.model.entity.Context;
import org.flashCardManager.view.ErrorDetailsView;
import org.flashCardManager.view.InputHelper;
import org.flashCardManager.view.MeaningView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MeaningApp {

    private final MeaningController meaningController;

    public MeaningApp(MeaningController meaningController) {
        this.meaningController = meaningController;
    }
    //exampleApp

    public void acoesMeanings(String cardId) {
        int opAcoesMeaning;

        do {
            MeaningView.mostrarAcoesMeanings();
            opAcoesMeaning = InputHelper.lerOpcaoInt("Escolha uma acao: ");
            tratarAcoesMeanings(opAcoesMeaning, cardId);
        } while (opAcoesMeaning != 0);
    }

    private void tratarAcoesMeanings(int opAcoesMeanings, String cardId) {
        switch (opAcoesMeanings) {
            case 1 -> criarMeaning(cardId);
            case 2 -> mostrarMeaningsPorCard(cardId);
            case 3 -> System.out.println("Acessar um meaning");
            case 0 -> System.out.println("Voltando...");
            default -> System.out.println("Escolha uma opcao valida");
        }
    }

    private void criarMeaning(String cardId) {
        String definition = InputHelper.lerString("Informe a definicao: ");

        int quantContext = InputHelper.lerOpcaoInt("Informe quantos contexts vai inserir: ");
        Set<Context> contexts = new HashSet<>();

        for(var i = 0; i < quantContext; i++) {
            Context context = Context.valueOf(InputHelper.lerString("Informe context: "));
            contexts.add(context);
        }

        Result<MeaningRequestResponse> result = meaningController.create(new MeaningRequestCreate(cardId, definition, contexts));

        if(!result.success()) {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void mostrarMeaningsPorCard(String cardId) {
        Result<List<MeaningRequestResponse>> result = meaningController.getByCardId(cardId);

        if(result.success()) {
            MeaningView.mostrarMeaningsPorCard(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }



}
