package matches.console;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Reads a number from the console, may throw an InputMismatchException */
public class ReadDataOfConsole implements InputData {

    @Override
    public int getInputData() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}