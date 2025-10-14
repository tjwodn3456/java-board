package project1.board;

public class AppConfig {

    public BoardRepository boardRepository(){
        return new Memory();
    }

    public Logic logic(){
        return new Logic(boardRepository());
    }

    public Print print(){
        return new Print();
    }

    public Menu menu(){
        return new Menu(print(), logic());
    }
}
