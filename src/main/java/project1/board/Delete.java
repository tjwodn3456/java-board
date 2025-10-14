package project1.board;

import java.util.InputMismatchException;

public class Delete implements Board{

    @Override
    public void execute(Print pr, Logic lg) {
        try {
            int id = pr.printAskNumberDelete();
            if (lg.isExitContent(id)) {
                lg.deletePost(id);
                pr.printSuccessDelete();
            } else {
                pr.printNotFind();
            }
        }catch (InputMismatchException e){
            System.out.println("숫자를 입력하세요.");
        }

    }
}
