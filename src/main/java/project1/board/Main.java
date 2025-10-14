package project1.board;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Menu menu = appConfig.menu();
        menu.runMenu();
    }
}
