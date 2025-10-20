package project1.board;

public class Exit implements MenuAction {
    @Override
    public ActionResult execute(Print pr, Logic lg) {
        pr.printExit();
    }
}
