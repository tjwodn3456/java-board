package project1.board;

public class Menu {
    private final Print pr;
    private final Logic lg;

    public Menu(Print pr, Logic lg){
        this.pr = pr;
        this.lg = lg;
    }

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
                pr.printIncorrectMenu();
            }
        }
    }
}
