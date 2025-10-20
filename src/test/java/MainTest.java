import org.junit.jupiter.api.Test;
import project1.board.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

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
    public void printEntryTest() {




    }
}
