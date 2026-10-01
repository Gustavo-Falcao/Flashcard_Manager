package org.flashCardManager.view;

import org.flashCardManager.model.dto.deckDto.DeckResponse;

import java.util.List;

public class DeckView {

    private DeckView() {}

    public static void mostrarAcoesDecks() {
        System.out.println("\n\n+ ------------------------------ +");
        System.out.println("| Acoes meus decks               |");
        System.out.println("----------------------------------");
        System.out.println("| [1] - Criar deck               |");
        System.out.println("| [2] - Ver meus decks           |");
        System.out.println("| [3] - Acessar um deck          |");
        System.out.println("| [0] - Voltar                   |");
        System.out.println("+ ------------------------------ +");
    }

    public static void mostrarDeck(DeckResponse deckResponse) {
        System.out.println("\n\n");
        System.out.println(" << -- " + deckResponse.name() + " -- >>");
    }

    public static void mostrarAcoesDeck() {
        System.out.println("\n+ ------------------------------ +");
        System.out.println("| Acoes do deck                  |");
        System.out.println("----------------------------------");
        System.out.println("| [1] - Atualizar dados          |");
        System.out.println("| [2] - Acessar cards            |");
        System.out.println("| [0] - Voltar                   |");
        System.out.println("+ ------------------------------ +");
    }

    public static void mostrarDecksPorUsuario(List<DeckResponse> deckResponseList) {
        String tituloMenu = "Meus decks";

        List<String> deckOptions = deckResponseList.stream()
                .map(deckResponse -> " [" + deckResponse.id() + "] - " + deckResponse.name())
                .toList();

        int maiorLinhaNameDeck = tituloMenu.length();

        for(var deckOption : deckOptions) {
            maiorLinhaNameDeck = Math.max(maiorLinhaNameDeck, deckOption.length());
        }

        final int maiorLinhaOpNameDeck = maiorLinhaNameDeck;
        int marginLado = 6;

        String linaMenu = "+ " + "-".repeat((maiorLinhaNameDeck + marginLado) - 3) + " +";

        int paddingTitulo = ((maiorLinhaNameDeck - tituloMenu.length()) + marginLado) - 2;

        String tituloMenuFormado = "| " + tituloMenu + " ".repeat(paddingTitulo) + "|";

        System.out.println("\n\n" + linaMenu);
        System.out.println(tituloMenuFormado);
        System.out.println(linaMenu);
        deckOptions.stream()
                .forEach(deckOption ->
                        System.out.println(
                                "|" +
                                deckOption +
                                " ".repeat((maiorLinhaOpNameDeck - deckOption.length()) + (marginLado - 1)) +
                                "|"
                        )
                );

        System.out.println(linaMenu);
    }
}
