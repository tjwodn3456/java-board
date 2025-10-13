package project1.board;

import java.util.HashMap;

public class List implements Board {

    @Override
    public void execute(Print pr, Logic lg) {
        HashMap<Integer, Post> newMap = new HashMap<>(Post.getMap());
        for (int i = 1; i < newMap.size()+1; i++) {
            pr.printKeyList(i);
            pr.printTitleList(i);
        }
        System.out.println();
    }
}
