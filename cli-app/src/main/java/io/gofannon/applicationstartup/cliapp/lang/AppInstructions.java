package io.gofannon.applicationstartup.cliapp.lang;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public record AppInstructions(
        @NotNull Command command,
        @NotNull Path basePath
) {
}
