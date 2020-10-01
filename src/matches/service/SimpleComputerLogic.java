package matches.service;

/** Implements computer logic, if possible, chooses a winning strategy */
public class SimpleComputerLogic implements ComputerLogicService {

    @Override
    public int getCountMatchesForDelete(int countMatchesOnTable) {
        return (countMatchesOnTable-1)%4==0
                ? (1 + (int) (Math.random()*2))
                : (countMatchesOnTable-1)%4;
    }
}