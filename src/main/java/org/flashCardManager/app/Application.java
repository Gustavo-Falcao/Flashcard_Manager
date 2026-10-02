package org.flashCardManager.app;

import org.flashCardManager.controller.*;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.jsonRepository.*;
import org.flashCardManager.model.dto.userDto.UserRequestCreate;
import org.flashCardManager.model.dto.userDto.UserRequestLogin;
import org.flashCardManager.model.dto.userDto.UserResponse;
import org.flashCardManager.repository.*;
import org.flashCardManager.service.*;
import org.flashCardManager.view.ApplicationView;
import org.flashCardManager.view.ErrorDetailsView;
import org.flashCardManager.view.InputHelper;

public class Application {

    //Instancias User
    private final UserApp userApp;
    private final UserController userController;
    private final UserService userService;
    private final UserRepository userRepository;

    //Instancias Deck
    private final DeckApp deckApp;
    private final DeckController deckController;
    private final DeckService deckService;
    private final DeckRepository deckRepository;

    //Instancias Card
    private final CardApp cardApp;
    private final CardController cardController;
    private final CardService cardService;
    private final CardRepository cardRepository;

    //Instancias Meaning
    private final MeaningApp meaningApp;
    private final MeaningController meaningController;
    private final MeaningService meaningService;
    private final MeaningRepository meaningRepository;

    //Instancias Example
    private final ExampleApp exampleApp;
    private final ExampleController exampleController;
    private final ExampleService exampleService;
    private final ExampleRepository exampleRepository;

    //Instancias Auth
    private final AuthService authService;
    private final AuthController authController;

    public Application() {
        //User service precisa de userRepository
        //Deck service precisa de deckRepository e cardRepository
        //Card service precisa de cardRepository e deckRepository
        //Meaning service precisa de meaningRepository e cardRepository
        //Example service precisa de exampleRepository e meaningRepository

        DeckJsonRepository deckJsonRepository = new DeckJsonRepository();
        CardJsonRepository cardJsonRepository = new CardJsonRepository();
        MeaningJsonRepository meaningJsonRepository = new MeaningJsonRepository();

        userRepository = new UserJsonRepository();
        deckRepository = deckJsonRepository;
        cardRepository = cardJsonRepository;
        meaningRepository = meaningJsonRepository;
        exampleRepository = new ExampleJsonRepository();

        userService = new UserService(userRepository);
        deckService = new DeckService(deckRepository, cardRepository);
        cardService = new CardService(cardRepository, deckRepository);
        meaningService = new MeaningService(meaningRepository, cardRepository);
        exampleService = new ExampleService(exampleRepository, meaningRepository);
        authService = new AuthService(userRepository);

        userController = new UserController(userService);
        deckController = new DeckController(deckService);
        cardController = new CardController(cardService);
        meaningController = new MeaningController(meaningService);
        exampleController = new ExampleController(exampleService);
        authController = new AuthController(authService);

        exampleApp = new ExampleApp(exampleController);
        meaningApp = new MeaningApp(meaningController, exampleApp);
        cardApp = new CardApp(cardController, meaningApp);
        deckApp = new DeckApp(deckController, cardApp);
        userApp = new UserApp(userController, deckApp);
    }

    public void runApplication() {
        int opMenuHome;
        do {
            ApplicationView.menuHome();
            opMenuHome = InputHelper.lerOpcaoInt("Escolha uma acao: ");
            tratarOpMenuHome(opMenuHome);
        } while (opMenuHome != 0);
        InputHelper.encerrarInput();
    }

    private void tratarOpMenuHome(int opMenuHome) {
        switch (opMenuHome) {
            case 1 -> executarLogin();
            case 2 -> executarCadastro();
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Escolha uma acao valida!");
        }
    }

    private void executarLogin() {
        String email = InputHelper.lerString("Digite o email: ");
        String password = InputHelper.lerString("Digite a senha: ");

        Result<UserResponse> result = authController.authenticate(new UserRequestLogin(email, password));

        if(result.success()) {
            userApp.acoesUser(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

    private void executarCadastro() {
        String name = InputHelper.lerString("Digite seu nome: ");
        String email = InputHelper.lerString("Digite o seu email: ");
        String password = InputHelper.lerString("Digite uma senha: ");

        Result<UserResponse> result = userController.create(new UserRequestCreate(name, email, password));

        if(result.success()) {
            userApp.acoesUser(result.data());
        } else {
            ErrorDetailsView.show(result.errorType(), result.errorMessage());
        }
    }

}
