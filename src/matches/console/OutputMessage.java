package matches.console;

public interface OutputMessage {
    void showStartGameMessage();
    void showCountMatchesOnTable(int count);
    void showComputerMove(int countMatchesForDelete);
    void showPlayerMove();
    void wrongCharacter();
    void wrongCountMatches();
    void showEndGameMessage(boolean isMovePlayer);
}
