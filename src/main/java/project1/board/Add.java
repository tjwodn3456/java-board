package project1.board;

public class Add implements Board {

    @Override
    public void execute(Print pr, Logic lg) {
        String title = pr.printAskTitle();
        String content = pr.printAskContent();
        lg.addNewPost(title, content);
        pr.printSuccessRegist();
    }
}
