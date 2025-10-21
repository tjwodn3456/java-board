package project1.board;

public class Add implements AuthenticatedAction {

    @Override
    public ActionResult execute(Print pr, Logic lg, User user, InputReader inputReader) {
        pr.printAskTitle();
        String title = inputReader.getValidStringInput();
        pr.printAskContent();
        String content = inputReader.getValidStringInput();
        lg.addNewPost(title, content, user.getUserId());
        pr.printSuccessRegist();
        return ActionResult.SUCCESS;
    }
}
