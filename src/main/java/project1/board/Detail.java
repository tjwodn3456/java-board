package project1.board;

public class Detail implements PublicMenuAction {

    @Override
    public ActionResult execute(Print pr, Logic lg, InputReader inputReader) {
            pr.printAskNumberDetail();
        int id = inputReader.getValidIntegerInput();
        if (lg.isExitContent(id)) {
            Post foundPost = lg.findPost(id);
            String title = foundPost.getTitle();
            String content = foundPost.getContent();
            pr.printTitle(title);
            pr.printContent(content);
            System.out.println();
            System.out.println();
            return ActionResult.SUCCESS;
        } else {
            pr.printNotFind();
            return ActionResult.FAILURE;
        }
    }
}
