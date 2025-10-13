package project1.board;

import java.util.InputMismatchException;

public class Detail implements Board{

    @Override
    public void execute(Print pr, Logic lg) {
        try {
            int num = pr.printAskNumberDetail();
            if (lg.isExitContent(num)) {
                pr.printTitleList(num);
                pr.printContentList(num);
                System.out.println();
                System.out.println();
            } else {
                pr.printNotFind();
            }
        }catch (InputMismatchException e){
            System.out.println("숫자를 입력하세요.");
        }
    }
}
