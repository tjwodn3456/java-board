package project1.board;

import java.util.InputMismatchException;

public class Update implements AuthenticatedAction {

    @Override
    public ActionResult execute(Print pr, Logic lg, User user, InputReader inputReader) {
        pr.printAskNumberUpdate();
        int id = inputReader.getValidIntegerInput();
        if (lg.isExitContent(id)) {
            Post post = lg.findPost(id);
            pr.printAskUpdateTitle();
            String newTitle = inputReader.getValidStringInput();
            pr.printAskUpdateContent();
            String newContent = inputReader.getValidStringInput();
            lg.updatePost(id, newTitle, newContent);
            pr.printSuccessUpdate();
            return ActionResult.SUCCESS;
        } else {
            pr.printNotFind();
            return ActionResult.FAILURE;
        }
    }
}
