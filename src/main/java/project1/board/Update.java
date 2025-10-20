package project1.board;

import java.util.InputMismatchException;

public class Update implements MenuAction {

    @Override
    public ActionResult execute(Print pr, Logic lg) {
        try {
            int id = pr.printAskNumberUpdate();
            if (lg.isExitContent(id)) {
                Post post = lg.findPost(id);
                String newTitle = pr.printAskUpdateTitle();
                String newContent = pr.printAskUpdateContent();
                lg.updatePost(id, newTitle, newContent);
                pr.printSuccessUpdate();
                return ActionResult.SUCCESS;
            } else {
                pr.printNotFind();
                return ActionResult.FAILURE;
            }
        }catch (InputMismatchException e){
            System.out.println("숫자를 입력하세요.");
            pr.clearScannerBuffer();
            return ActionResult.FAILURE;
        }
    }
}
