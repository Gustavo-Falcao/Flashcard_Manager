package org.flashCardManager.view;

import org.flashCardManager.model.dto.exampleDto.ExampleRequestResponse;

import java.util.List;

public class ExampleView {

    public static void mostrarAcoesExamples() {
        System.out.println("\n\n+ ------------------------------ +");
        System.out.println("| Acoes examples                 |");
        System.out.println("----------------------------------");
        System.out.println("| [1] - Ver meus examples        |");
        System.out.println("| [2] - Acessar um example       |");
        System.out.println("| [0] - Voltar                   |");
        System.out.println("+ ------------------------------ +");
    }

    public static void mostrarAcoesExample() {
        System.out.println("\n+ ------------------------------ +");
        System.out.println("| Acoes do example               |");
        System.out.println("----------------------------------");
        System.out.println("| [1] - Visualizar dados         |");
        System.out.println("| [0] - Voltar                   |");
        System.out.println("+ ------------------------------ +");
    }

    public static void mostrarExample(ExampleRequestResponse exampleRequestResponse) {
        System.out.println("\n\n+ ------------------------------ +");
        System.out.println("| Example                         |");
        System.out.println("----------------------------------");
        System.out.println(" --> Text: " + exampleRequestResponse.getText());
        if(exampleRequestResponse.getVerbTense() != null) {
            System.out.println(" --> Verb tense: " + exampleRequestResponse.getVerbTense().toShort());
        }
    }

    public static void menuAcoesAtualizarDadosExample() {
        System.out.println("\n\n+ ------------------------------ +");
        System.out.println("| Atualizar Dados                |");
        System.out.println("----------------------------------");
        System.out.println("| [1] - Text                     |");
        System.out.println("| [2] - TargetToBeHidden         |");
        System.out.println("| [3] - VerbTense                |");
        System.out.println("| [0] - Voltar                   |");
        System.out.println("+ ------------------------------ +");
    }

    public static void mostrarExamplesPorMeaning(List<ExampleRequestResponse> exampleRequestResponseList) {
        String tituloMenu = "Examples";

        List<String> exampleOptions = exampleRequestResponseList.stream()
                .map(exampleRequestResponse -> " [" + exampleRequestResponse.getId() + "] - " + exampleRequestResponse.getText().substring(0, 20) + "...")
                .toList();

        int maiorLinhaTextExample = tituloMenu.length();

        for(var exampleOption : exampleOptions) {
            maiorLinhaTextExample = Math.max(maiorLinhaTextExample, exampleOption.length());
        }

        final int maiorLinhaOpExample = maiorLinhaTextExample;
        int marginLado = 6;

        String linaMenu = "+ " + "-".repeat((maiorLinhaTextExample + marginLado) - 3) + " +";

        int paddingTitulo = ((maiorLinhaTextExample - tituloMenu.length()) + marginLado) - 2;

        String tituloMenuFormado = "| " + tituloMenu + " ".repeat(paddingTitulo) + "|";

        System.out.println("\n\n" + linaMenu);
        System.out.println(tituloMenuFormado);
        System.out.println(linaMenu);
        exampleOptions.stream()
                .forEach(exampleOp ->
                        System.out.println(
                                "|" +
                                        exampleOp +
                                        " ".repeat((maiorLinhaOpExample - exampleOp.length()) + (marginLado - 1)) +
                                        "|"
                        )
                );

        System.out.println(linaMenu);
    }
}
