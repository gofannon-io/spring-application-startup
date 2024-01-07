package io.gofannon.applicationstartup.cliapp;

import io.gofannon.applicationstartup.cliapp.lang.AppInstructions;
import io.gofannon.applicationstartup.cliapp.cmdline.CmdLineParser;
import io.gofannon.applicationstartup.cliapp.cmdline.InvalidCommandLineException;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CliAppApplication implements CommandLineRunner, ExitCodeGenerator {

    public static void main(String[] args) {
        SpringApplication.run(CliAppApplication.class, args);
    }

    private final Logger logger = LoggerFactory.getLogger(CliAppApplication.class);

    private int exitCode = 0;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting application");
        logger.debug("Command line argument : " + String.join(" ", args));

        try {

            AppInstructions instructions = CmdLineParser.parseCmdLine(args);
            execute(instructions);
            logger.info("Exit application");

        } catch (InvalidCommandLineException ex) {
            logger.error("Fail to parse command line: " + ex.getMessage());
            logger.error("Exit application on failure");
            this.exitCode = -1;
        } catch (RuntimeException ex) {
            logger.error("Fail to execute application: " + ex.getMessage());
            logger.error("Exit application on failure");
            this.exitCode = -2;
        }
    }

    private void execute(@NotNull AppInstructions instructions) {
        logger.info("Work in progress on command " + instructions.command());
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
