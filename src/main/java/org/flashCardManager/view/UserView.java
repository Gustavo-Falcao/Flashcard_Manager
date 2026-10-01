package org.flashCardManager.view;

import org.flashCardManager.model.dto.userDto.UserResponse;

public class UserView {

    private UserView() {}

    public static void menuAcoesUser() {
        System.out.println("\n\n+ ------------------------------ +");
        System.out.println("| Minhas acoes                   |");
        System.out.println("----------------------------------");
        System.out.println("| [1] - Atualizar dados          |");
        System.out.println("| [2] - Ver meus dados           |");
        System.out.println("| [3] - Acessar decks            |");
        System.out.println("| [0] - Sair                     |");
        System.out.println("+ ------------------------------ +");
    }

    public static void mostrarDados(UserResponse userResponse) {
        System.out.println("\n\n+ ------------------------------ +");
        System.out.println("| Meus dados                     |");
        System.out.println("----------------------------------");
        System.out.println(" --> Nome: " + userResponse.name());
        System.out.println(" --> Email: " + userResponse.email());
    }
}
