package project1.board;

public class Exit implements PublicMenuAction {
    @Override
    public ActionResult execute(Print pr, Logic lg, InputReader inputReader) {
        pr.printExit();
        return ActionResult.SUCCESS;
    }
}
