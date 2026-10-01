package org.flashCardManager.view;

public class ApplicationView {

    private ApplicationView() {}

    public static void menuHome() {
        System.out.println("\n\n+ ------------------------------ +");
        System.out.println("| Bem-vindo ao Flashcard Manager |");
        System.out.println("----------------------------------");
        System.out.println("| [1] - Entrar                   |");
        System.out.println("| [2] - Cadastrar                |");
        System.out.println("| [0] - Sair                     |");
        System.out.println("+ ------------------------------ +");
    }

}
