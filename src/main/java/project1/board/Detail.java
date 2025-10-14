package project1.board;

import java.util.InputMismatchException;

public class Detail implements Board{

    @Override
    public void execute(Print pr, Logic lg) {
        try {
            int id = pr.printAskNumberDetail();
            if (lg.isExitContent(id)) {
                String title = lg.findPost(id).getTitle();
                String content = lg.findPost(id).getContent();
                pr.printTitle(title);
                pr.printContent(content);
                System.out.println();
                System.out.println();
            } else {
                pr.printNotFind();
            }
        }catch (InputMismatchException e){
            System.out.println("숫자를 입력하세요.");
            pr.clearScannerBuffer();
        }
    }
}
