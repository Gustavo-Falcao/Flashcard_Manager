package org.flashCardManager.view;

import org.flashCardManager.model.dto.cardDto.CardRequestResponse;

import java.util.List;

public class CardView {

    public static void mostrarAcoesCards() {
        System.out.println("\n\n+ ------------------------------ +");
        System.out.println("| Acoes meus cards               |");
        System.out.println("----------------------------------");
        System.out.println("| [1] - Criar card               |");
        System.out.println("| [2] - Ver meus cards           |");
        System.out.println("| [3] - Acessar um card          |");
        System.out.println("| [0] - Voltar                   |");
        System.out.println("+ ------------------------------ +");
    }

    public static void mostrarCard(CardRequestResponse cardRequestResponse) {
        System.out.println("\n\n+ ------------------------------ +");
        System.out.println("| Card                           |");
        System.out.println("----------------------------------");
        System.out.println(" --> Name: " + cardRequestResponse.name());
        System.out.println(" --> Context: " + cardRequestResponse.context().toShow());
        System.out.println(" --> Synonym: " + cardRequestResponse.synonym());
        System.out.println(" --> Phonetic: " + cardRequestResponse.phonetic());
    }

    public static void mostrarAcoesCard() {
        System.out.println("\n+ ------------------------------ +");
        System.out.println("| Acoes do card                  |");
        System.out.println("----------------------------------");
        System.out.println("| [1] - Atualizar dados          |");
        System.out.println("| [2] - Acessar meanings         |");
        System.out.println("| [0] - Voltar                   |");
        System.out.println("+ ------------------------------ +");
    }

    public static void mostrarCardsPorDeck(List<CardRequestResponse> cardRequestResponseList) {
        String tituloMenu = "Cards";

        List<String> cardOptions = cardRequestResponseList.stream()
                .map(cardRequestResponse -> " [" + cardRequestResponse.id() + "] - " + cardRequestResponse.name())
                .toList();

        int maiorLinhaNameCard = tituloMenu.length();

        for(var cardOption : cardOptions) {
            maiorLinhaNameCard = Math.max(maiorLinhaNameCard, cardOption.length());
        }

        final int maiorLinhaOpNameCard = maiorLinhaNameCard;
        int marginLado = 6;

        String linaMenu = "+ " + "-".repeat((maiorLinhaNameCard + marginLado) - 3) + " +";

        int paddingTitulo = ((maiorLinhaNameCard - tituloMenu.length()) + marginLado) - 2;

        String tituloMenuFormado = "| " + tituloMenu + " ".repeat(paddingTitulo) + "|";

        System.out.println("\n\n" + linaMenu);
        System.out.println(tituloMenuFormado);
        System.out.println(linaMenu);
        cardOptions.stream()
                .forEach(deckOption ->
                        System.out.println(
                                "|" +
                                        deckOption +
                                        " ".repeat((maiorLinhaOpNameCard - deckOption.length()) + (marginLado - 1)) +
                                        "|"
                        )
                );

        System.out.println(linaMenu);
    }
}
