package org.flashCardManager.app;

import org.flashCardManager.controller.UserController;
import org.flashCardManager.model.dto.userDto.UserResponse;
import org.flashCardManager.view.InputHelper;
import org.flashCardManager.view.UserView;

public class UserApp {

    private final UserController userController;

    public UserApp(UserController userController) {
        this.userController = userController;
    }

    public void acoesUser(UserResponse userResponse) {
        int opAcoesUser;
        do {
            UserView.menuAcoesUser();
            opAcoesUser = InputHelper.lerOpcaoInt("Escolha uma acao: ");
            tratarAcoesUser(userResponse, opAcoesUser);
        } while (opAcoesUser != 0);
    }

    private void tratarAcoesUser(UserResponse userResponse, int opAcoesUser) {
        switch (opAcoesUser) {
            case 1 -> System.out.println("Atualizar dados");
            case 2 -> UserView.mostrarDados(userResponse);
            case 3 -> System.out.println("acessar decks");
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Escolha uma acao valida!");
        }
    }
}
