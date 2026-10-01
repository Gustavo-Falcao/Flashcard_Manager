package org.flashCardManager.view;

import java.util.Scanner;

public class InputHelper {

    private final static Scanner scanner = new Scanner(System.in);

    public static int lerOpcaoInt(String label) {
        System.out.print(label);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String lerString(String label) {
        System.out.print(label);
        return scanner.nextLine();
    }

    public static void encerrarInput() {
        scanner.close();
    }
}
