package project1.board;

public interface AuthenticatedAction {
    ActionResult execute(Print pr, Logic lg, User user, InputReader inputReader);
}
