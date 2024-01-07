package io.gofannon.applicationstartup.cliapp.cmdline;

import io.gofannon.applicationstartup.cliapp.lang.AppInstructions;
import io.gofannon.applicationstartup.cliapp.lang.Command;
import org.jetbrains.annotations.NotNull;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Locale;

public class CmdLineParser {

    /**
     * Parse the command line arguments and generates the application instructions
     *
     * @param arguments the command line arguments
     * @return the application instructions
     * @throws InvalidCommandLineException if the command line arguments are not valid
     */
    public static @NotNull AppInstructions parseCmdLine(String... arguments) throws InvalidCommandLineException{
        var interpreter = new CmdLineParser(arguments);
        return interpreter.getInstruction();
    }

    private final @NotNull String rawCommand;
    private final @NotNull String rawBasePath;

    private final @NotNull Command command;
    private final @NotNull Path basePath;

    private CmdLineParser(String... args) {
        if( args.length != 2)
            throw new InvalidCommandLineException("Argument count shall be equal to 2");

        this.rawCommand =args[0];
        this.rawBasePath = args[1];

        this.command = buildCommand();
        this.basePath = buildBasePath();
    }


    private @NotNull Command buildCommand() {
        var formattedCommand = rawCommand.toLowerCase(Locale.getDefault());
        return switch (formattedCommand) {
            case "dollar" -> Command.DOLLAR;
            case "space" -> Command.SPACE;
            case "star" -> Command.STAR;
            default -> throw new InvalidCommandLineException("Unknown command '" + rawCommand + "'");
        };
    }

    private @NotNull Path buildBasePath() {
        try {

            var path = Path.of(rawBasePath);
            checkExistingDirectory(path);

            return path;

        } catch (InvalidPathException ex) {
            throw new InvalidCommandLineException("Path '" + rawBasePath + "' is not valid", ex);
        }
    }

    private void checkExistingDirectory(@NotNull Path path) {
        var directory = path.toFile();

        if (!directory.exists())
            throw new InvalidCommandLineException("Path '" + rawBasePath + "' does not exist");

        if (!directory.isDirectory())
            throw new InvalidCommandLineException("Path '" + rawBasePath + "' is not a directory");
    }

    /**
     * Get the application instruction deduced on the
     *
     * @return the application instruction
     */
    @NotNull
    private AppInstructions getInstruction() {
        return new AppInstructions(command, basePath);
    }
}
