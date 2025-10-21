import org.junit.jupiter.api.Test;
import project1.board.*;

public class MainTest {


    @Test
    public void ContentTest() {
        Post content1 = new Post(1,"안녕", "하세요. 1");
        Post content2 = new Post(2,"안녕", "하세요. 2");

    }

    @Test
    public void ContentPrivateTest() {
        Post content1 = new Post(1,"안녕", "하십니까");
        System.out.println(content1.toString());
        System.out.println(content1.getTitle());
    }

    @Test
    public void LoginTest() {
        AppConfig appConfig = new AppConfig();
        Logic lg = appConfig.logic();
        lg.newUser("tj", "1234");
        Login login = new Login();
        User loginUser =login.execute(appConfig.print(), appConfig.logic());
        lg.addNewPost("a", "b", loginUser.getUserId());



    }
    @Test
    public void TypeMain() {
        System.out.println(TypeTest().getClass().getName());
    }

    public Object TypeTest () {
        String input = "s";
        return Integer.parseInt(input);}
}
