package project1.board;

import java.util.InputMismatchException;

public class Update implements Board{

    @Override
    public void execute(Print pr, Logic lg) {
        try {
            int num = pr.printAskNumberUpdate();
            if (lg.isExitContent(num)) {
                Post post = lg.findPost(num);
                String newTitle = pr.printAskUpdateTitle();
                String newContent = pr.printAskUpdateContent();
                lg.updatePost(post, newTitle, newContent);
                pr.printSuccessUpdate();
            } else {
                pr.printNotFind();
            }
        }catch (InputMismatchException e){
            System.out.println("숫자를 입력하세요.");
        }
    }
}
