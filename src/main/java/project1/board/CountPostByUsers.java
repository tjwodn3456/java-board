package project1.board;

import java.util.List;

public class CountPostByUsers implements PublicMenuAction {
    @Override
    public ActionResult execute(Print pr, Logic lg, InputReader inputReader) {
        List<UserPostCountDto> countUserPosts = lg.countPostByUsers();
        for (UserPostCountDto dto : countUserPosts) {
            pr.printCountPostsByUsers(dto);
        }
        return ActionResult.SUCCESS;
    }
}
