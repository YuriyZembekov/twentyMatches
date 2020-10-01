package matches.service;

import matches.console.InputData;
import matches.console.OutputMessage;
import matches.console.ReadDataOfConsole;
import matches.console.OutputMessageToConsole;

import java.util.InputMismatchException;

/** Create variables needed gor the game */
public class GameLogic {
    private static final int COUNT_MATCHES = 20;
    private OutputMessage outputData;
    private InputData inputData;
    private ComputerLogicService computerLogicService;
    private int countMatchesOnTable;
    private boolean isMovePlayer = false;

    /** Defines implementations of interfaces*/
    // Модификатор доступа выбран public, чтобы игру можно было
    // запустить из другого класса
    public GameLogic() {
        outputData = new OutputMessageToConsole();
        inputData = new ReadDataOfConsole();
        computerLogicService = new SimpleComputerLogic();
        countMatchesOnTable = COUNT_MATCHES;
    }

    /** Implements the main logic of the game */
    public void startGame() {
        outputData.showStartGameMessage();
        while (countMatchesOnTable > 1) {
            if (isMovePlayer) {
                playerMove();
            } else {
                computerMove();
            }
            isMovePlayer = !isMovePlayer;
        }
        outputData.showEndGameMessage(isMovePlayer);
    }

    private boolean isWrongCountMatchesForDelete(int countMatches) {
        return (countMatches < 1 || 3 < countMatches);
    }

    private void computerMove() {
        int countMatchesForDeleteComputer;

        outputData.showCountMatchesOnTable(countMatchesOnTable);
        countMatchesForDeleteComputer = computerLogicService.getCountMatchesForDelete(countMatchesOnTable);
        outputData.showComputerMove(countMatchesForDeleteComputer);
        countMatchesOnTable -= countMatchesForDeleteComputer;
    }

    private void playerMove() {
        int countMatchesForDeletePlayer = 0;

        outputData.showCountMatchesOnTable(countMatchesOnTable);
        do {
            outputData.showPlayerMove();
            try {
                countMatchesForDeletePlayer = inputData.getInputData();
            } catch (InputMismatchException e) {
                outputData.wrongCharacter();
                continue;
            }
            if (isWrongCountMatchesForDelete(countMatchesForDeletePlayer)) {
                outputData.wrongCountMatches();
            }
        } while (isWrongCountMatchesForDelete(countMatchesForDeletePlayer));
        countMatchesOnTable -= countMatchesForDeletePlayer;
    }

    /** Creates an instance of the class and starts the game */
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        gameLogic.startGame();
    }
}