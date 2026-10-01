package org.flashCardManager.app;

import org.flashCardManager.controller.UserController;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.userDto.UserRequestUpdate;
import org.flashCardManager.model.dto.userDto.UserResponse;
import org.flashCardManager.view.ErrorDetailsView;
import org.flashCardManager.view.InputHelper;
import org.flashCardManager.view.UserView;

public class UserApp {

    private final UserController userController;
    private final DeckApp deckApp;

    public UserApp(UserController userController, DeckApp deckApp) {
        this.userController = userController;
        this.deckApp = deckApp;
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
            case 1 -> atualizarDados(userResponse);
            case 2 -> UserView.mostrarDados(userResponse);
            case 3 -> deckApp.acoesDecks(userResponse.id());
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Escolha uma acao valida!");
        }
    }

    private void atualizarDados(UserResponse userResponse) {
        int opAcoesAtualizarDadosUser;

        do {
            UserView.mostrarDados(userResponse);
            UserView.menuAcoesAtualizarDadosUser();
            opAcoesAtualizarDadosUser = InputHelper.lerOpcaoInt("Escolha uma acao: ");
            userResponse = tratarAcoesAtualizarDadosUser(userResponse, opAcoesAtualizarDadosUser);
        } while (opAcoesAtualizarDadosUser != 0);
    }

    private UserResponse tratarAcoesAtualizarDadosUser(UserResponse userResponse, int opAcoesAtualizarDadosUser) {

        Result<UserResponse> result = null;

        switch (opAcoesAtualizarDadosUser) {
            case 1:
                String name = InputHelper.lerString("Informe o nome: ");
                result = userController.update(
                        new UserRequestUpdate.Builder()
                                .id(userResponse.id())
                                .name(name)
                                .build()
                        );
                break;
            case 2:
                String email = InputHelper.lerString("Informe o email: ");
                result = userController.update(
                        new UserRequestUpdate.Builder()
                                .id(userResponse.id())
                                .email(email)
                                .build()
                        );
                break;
            case 3:
                String password = InputHelper.lerString("Informe a senha: ");
                result = userController.update(
                        new UserRequestUpdate.Builder()
                                .id(userResponse.id())
                                .password(password)
                                .build()
                        );
                break;
            case 0:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Escolha uma opcao valida");
                break;
        }

        if(result != null) {
            if(!result.success()) {
                ErrorDetailsView.show(result.errorType(), result.errorMessage());
            } else {
                return result.data();
            }
        }

        return userResponse;
    }




}
