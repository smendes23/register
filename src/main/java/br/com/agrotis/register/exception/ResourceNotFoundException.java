package br.com.agrotis.register.exception;

public class ResourceNotFoundException extends RuntimeException {

    public static void throwIf(boolean test) {

        if (test) {

            throw new ResourceNotFoundException();
        }
    }
}
