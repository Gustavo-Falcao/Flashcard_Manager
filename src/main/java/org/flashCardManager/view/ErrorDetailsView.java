package org.flashCardManager.view;

import org.flashCardManager.controller.common.Result;

public class ErrorDetailsView {

    private ErrorDetailsView() {}

    public static void show(Result<?> result) {
        if(!result.success()) {
            switch (result.errorType()) {
                case VALIDATION -> System.out.println("\n⚠️ Dado invalido: " + result.errorMessage());
                case NOT_FOUND -> System.out.println("\n⚠️ Dado nao encontrado: " + result.errorMessage());
                case PERSISTENCE -> System.out.println("\n⚠️ Erro na persistencia de dados: " + result.errorMessage());
                case AUTHENTICATION -> System.out.println("\n⚠️ Erro na autenticacao: " + result.errorMessage());
                case UNEXPECTED -> System.out.println("\n⚠️ " + result.errorMessage());
            }
        }
    }
}
