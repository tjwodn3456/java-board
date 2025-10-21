package project1.board;

public class Menu {
    private final Login login;
    private final Print pr;
    private final Logic lg;
    private final InputReader inputReader;

    public Menu(Login login, Print pr, Logic lg, InputReader inputReader) {
        this.login = login;
        this.pr = pr;
        this.lg = lg;
        this.inputReader = inputReader;
    }

    public void runMenu() {
        while (true) {
            User user = login.execute(pr, lg, inputReader);
            if (user != null) {
                PublicMenuEnum menu = null;
                while (true) {
                    pr.printTodo();
                    String input = inputReader.getValidStringInput();
                    if (inputReader.isNumeric(input)) {
                        continue;
                    }
                    PublicMenuEnum publicMenu = PublicMenuEnum.fromString(input);
                    if (publicMenu != null) {
                        publicMenu.execute(pr, lg, inputReader);
                        if (publicMenu == PublicMenuEnum.EXIT) {
                            return;
                        }
                    } else {
                        AuthenticatedMenuEnum authMenu = AuthenticatedMenuEnum.fromString(input);
                        if (authMenu != null) {
                            authMenu.execute(pr, lg, user, inputReader);
                        } else {
                            pr.printIncorrectMenu();
                        }
                    }
                }
            }
        }
    }
}
