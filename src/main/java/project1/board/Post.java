package project1.board;

import java.util.HashMap;
import java.util.Map;

public class Post {
    private String title;
    private String content;
    private int id;


    public Post(int id,String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    //수정 메서드
    public void updatePostTitle(String title){
        this.title = title;
    }

    public void updatePostContent(String content){
        this.content = content;
    }
    
    // Getter 메서드
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return title + " " + content;
    }
}
