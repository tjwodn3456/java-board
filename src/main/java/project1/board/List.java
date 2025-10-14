package project1.board;

import java.util.HashMap;

public class List implements Board {

    @Override
    public void execute(Print pr, Logic lg) {
        for (int i = 1; i < Post.getKey(); i++) {
            if (lg.isExitContent(i)) {
                pr.printKeyList(i);
                pr.printTitleList(i);
            }
        }
        System.out.println();
    }
}
