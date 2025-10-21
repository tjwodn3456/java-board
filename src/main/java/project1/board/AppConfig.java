package project1.board;

public class AppConfig {

    public BoardRepository boardRepository(){
        return new JdbcMemory();
    }

    public UserRepository userRepository(){return new JdbcUserRepository();}

    public Login login(){return new Login();}

    public Logic logic(){
        return new Logic(boardRepository(), userRepository());
    }

    public Print print(){
        return new Print();
    }

    public InputReader inputReader(){return new InputReader();}

    public Menu menu(){
        return new Menu(login(), print(), logic(), inputReader());
    }
}
