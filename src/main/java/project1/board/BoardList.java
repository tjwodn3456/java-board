package project1.board;

import java.util.List;

public class BoardList implements Board {

    @Override
    public void execute(Print pr, Logic lg) {
        List<Post> posts = lg.makeList();
        if (posts.isEmpty()) {
            pr.printNoPost();
        }
        for (Post post : posts) {
            pr.printPostSummary(post);
        }
        System.out.println();
    }
}
