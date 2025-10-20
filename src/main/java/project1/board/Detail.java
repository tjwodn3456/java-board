package project1.board;

import java.util.InputMismatchException;

public class Detail implements MenuAction {

    @Override
    public ActionResult execute(Print pr, Logic lg) {
        try {
            int id = pr.printAskNumberDetail();
            if (lg.isExitContent(id)) {
                Post foundPost = lg.findPost(id);
                String title = foundPost.getTitle();
                String content = foundPost.getContent();
                pr.printTitle(title);
                pr.printContent(content);
                System.out.println();
                System.out.println();
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
