package project1.board;

public class Exit implements Board {
    @Override
    public void execute(Print pr, Logic lg) {
        pr.printExit();
    }
}
