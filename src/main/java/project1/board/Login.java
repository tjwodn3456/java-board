package project1.board;

public class Login implements MenuAction {
    private Logic lg;
    private Print pr;

    @Override
    public ActionResult execute(Print pr, Logic lg) {
        String inputLoginId = pr.askLoginId();
        User user = lg.findUserByLoginId(inputLoginId);
        if (user != null) {
            String inputPassword = pr.askPassword();
            if (lg.isCorrectPassword(user.getPassword(), inputPassword)) {
                return ActionResult.SUCCESS;
            } else {
                pr.printIncorrectPassword();
                return ActionResult.FAILURE;
            }
        } else {
            pr.printIncorrectId();
            return ActionResult.FAILURE;
        }
    }
}
