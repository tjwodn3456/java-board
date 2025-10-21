package project1.board;

import java.util.ArrayList;
import java.util.List;

public class AuthorList implements PublicMenuAction {
    @Override
    public ActionResult execute(Print pr, Logic lg, InputReader inputReader) {
        List<PostListItemDto> postList = lg.authorMakeList();
        if (postList.isEmpty()) {
            pr.printNoPost();
        }
        for (PostListItemDto dto : postList) {
            pr.printPostSummary(dto);
        }
        System.out.println();
        return ActionResult.SUCCESS;
    }
}
