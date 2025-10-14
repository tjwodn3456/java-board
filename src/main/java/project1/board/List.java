package project1.board;

import java.util.ArrayList;

public class List implements Board {

    @Override
    public void execute(Print pr, Logic lg) {
        ArrayList<Post> list = new ArrayList<>(lg.makeList());
        for (int i = 0; i < Memory.getKey(); i++) {
            if (lg.isExitContent(i+1)) {
                System.out.println("=======================================================");
                pr.printKeyList(i+1);
                pr.printTitleList(list, i);
                pr.printContentList(list, i);
                System.out.println("======================================================");
            }
        }
        System.out.println();
    }
}
