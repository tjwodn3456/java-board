package project1.board;

public class Delete implements AuthenticatedAction {

    @Override
    public ActionResult execute(Print pr, Logic lg, User user, InputReader inputReader) {
        pr.printAskNumberDelete();
        int id = inputReader.getValidIntegerInput();
        if (lg.isExitContent(id)) {
            Post deletPost = lg.findPost(id);
            if (deletPost.getUserId() == user.getUserId()) {
                lg.deletePost(id);
                pr.printSuccessDelete();
                return ActionResult.SUCCESS;
            } else {
                pr.notYourPost();
                return ActionResult.FAILURE;
            }
        } else {
            pr.printNotFind();
            return ActionResult.FAILURE;
        }
    }
}
