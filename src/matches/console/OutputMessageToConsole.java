package matches.console;

/** Displays messages to the console*/
public class OutputMessageToConsole implements OutputMessage {

    @Override
    public void showStartGameMessage() {
        System.out.println("Игра началась!");
    }

    @Override
    public void showCountMatchesOnTable(int countMatches) {
        if (countMatches<=4){
            System.out.println("На столе осталось " + countMatches + " спички.");
        } else {
            System.out.println("На столе осталось " + countMatches + " спичек.");
        }
    }

    @Override
    public void showComputerMove(int countMatchesForDelete) {
        if (countMatchesForDelete==1){
            System.out.println("Ход компьютера. Компьютер забирает 1 спичку.");
        } else {
            System.out.println("Ход компьютера. Компьютер забирает " + countMatchesForDelete + " спички.");
        }
    }

    @Override
    public void showPlayerMove() {
        System.out.print(" - Ход игрока. Введите количество спичек: ");
    }

    @Override
    public void wrongCharacter() {
        System.out.println("Введите цифру!");
    }

    @Override
    public void wrongCountMatches() {
        System.out.println("Некорректное количество спичек!");
    }

    @Override
    public void showEndGameMessage(boolean isMovePlayer) {
        if (isMovePlayer) {
            System.out.println("Игроку осталась последняя спичка - игрок проиграл.");
        } else {
            System.out.println("Компьютеру осталась последняя спичка - компьютер проиграл");
        }
    }
}