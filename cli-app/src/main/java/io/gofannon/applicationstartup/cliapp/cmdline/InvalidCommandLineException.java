package io.gofannon.applicationstartup.cliapp.cmdline;

import org.jetbrains.annotations.NotNull;

public class InvalidCommandLineException extends RuntimeException {

    public InvalidCommandLineException(@NotNull String message) {
        super(message);
    }

    public InvalidCommandLineException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }

}
