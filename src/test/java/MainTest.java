import org.junit.jupiter.api.Test;
import project1.board.*;

import java.util.InputMismatchException;

public class MainTest {


    @Test
    public void ContentTest() {
        Post content1 = new Post("안녕", "하세요. 1");
        Post content2 = new Post("안녕", "하세요. 2");
        System.out.println(content1.getMap().get(1).toString());
        System.out.println(content2.getMap().get(2).toString());
    }

    @Test
    public void ContentPrivateTest() {
        Post content1 = new Post("안녕", "하십니까");
        System.out.println(content1.toString());
        System.out.println(content1.getTitle());
        content1.getMap().remove(1);
        System.out.println(content1.getMap().get(1));
    }

    @Test
    public void printEntryTest() {
        Post content1 = new Post("안녕1", "하십니까1");
        Post content2 = new Post("안녕2", "하십니까2");
        Post content3 = new Post("안녕3", "하십니까3");
        Post content4 = new Post("안녕4", "하십니까4");
        System.out.println(Post.getMap().toString());

    }

    @Test
    public void ExceptionCheck() {
        Print pr = new Print();
        Logic lg = new Logic();


        try {
            int num = pr.printAskNumberDetail();
            pr.printTitleList(num);
            System.out.println();
            pr.printContentList(num);
        }catch (InputMismatchException e){
            System.out.println("숫자를 입력하세요.");
        }

    }
}