package project1.board;

import java.util.InputMismatchException;

public class Delete implements MenuAction {

    @Override
    public ActionResult execute(Print pr, Logic lg) {
        try {
            int id = pr.printAskNumberDelete();
            if (lg.isExitContent(id)) {
                lg.deletePost(id);
                pr.printSuccessDelete();
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
