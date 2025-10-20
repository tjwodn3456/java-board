package project1.board;

public class Add implements MenuAction {

    @Override
    public ActionResult execute(Print pr, Logic lg) {
        String title = pr.printAskTitle();
        String content = pr.printAskContent();
        lg.addNewPost(title, content);
        pr.printSuccessRegist();
        return ActionResult.SUCCESS;
    }
}
