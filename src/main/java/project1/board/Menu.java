package project1.board;

public class Menu {
    Print pr = new Print();
    Logic lg = new Logic(new Memory());

    public void runMenu(){
        MenuEnum menu = null;
        while (true){
            String input = pr.printTodo();
            MenuEnum selectedMenu = MenuEnum.fromString(input);
            if (selectedMenu != null) {
                selectedMenu.execute(pr, lg);
                if (selectedMenu == MenuEnum.EXIT) {
                    return;
                }
            } else {
                pr.printIncorrectInput();
            }
        }
    }
}
