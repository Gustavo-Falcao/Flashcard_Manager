package org.flashCardManager.app;

import org.flashCardManager.controller.ExampleController;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.exampleDto.ExampleRequestResponse;
import org.flashCardManager.view.ErrorDetailsView;
import org.flashCardManager.view.ExampleView;
import org.flashCardManager.view.InputHelper;

import java.util.List;

public class ExampleApp {

    private final ExampleController exampleController;

    public ExampleApp(ExampleController exampleController) {
        this.exampleController = exampleController;
    }

    public void acoesExamples(String meaningId) {
        int opAcoesExample;

        do {
            ExampleView.mostrarAcoesExamples();
            opAcoesExample = InputHelper.lerOpcaoInt("Escolha uma acao: ");
            tratarAcoesExamples(opAcoesExample, meaningId);
        } while (opAcoesExample != 0);
    }

    private void tratarAcoesExamples(int opAcoesExample, String meaningId) {
        switch (opAcoesExample) {
            case 1 -> mostrarExamplesPorMeaning(meaningId);
            case 2 -> acessarExample(meaningId);
            case 0 -> System.out.println("Voltando...");
            default -> System.out.println("Escolha uma opca valida");
        }
    }

    private void mostrarExamplesPorMeaning(String meaningId) {
        Result<List<ExampleRequestResponse>> result = exampleController.getByMeaningId(meaningId);

        if(result.success()) {
            ExampleView.mostrarExamplesPorMeaning(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void acessarExample(String meaningId) {
        mostrarExamplesPorMeaning(meaningId);

        String idExample = InputHelper.lerString("Informe o id do example escolhido: ");

        Result<ExampleRequestResponse> result = exampleController.findById(idExample);

        if(result.success()) {
            mostrarAcoesExample(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void mostrarAcoesExample(ExampleRequestResponse exampleRequestResponse) {
        int opAcoesExample;

        do {
            ExampleView.mostrarAcoesExample();
            opAcoesExample = InputHelper.lerOpcaoInt("Escolha uma opcao: ");
            tratarAcoesExample(exampleRequestResponse, opAcoesExample);
        } while (opAcoesExample != 0);
    }

    private void tratarAcoesExample(ExampleRequestResponse exampleRequestResponse, int opAcoesExample) {
        switch (opAcoesExample) {
            case 1 -> ExampleView.mostrarExample(exampleRequestResponse);
        }
    }


}
