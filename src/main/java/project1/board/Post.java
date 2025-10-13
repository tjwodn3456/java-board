package project1.board;

import java.util.HashMap;
import java.util.Map;

public class Post {
    private static Map<Integer, Post> map = new HashMap<>();
    private String title;
    private String content;
    private static int key = 1;


    public Post(String title, String content) {
        this.content = content;
        this.title = title;
        map.put(key, this);
        key++;
    }

    public void deleteContent(int key) {
        map.remove(key);
    }

    // 수정, 내용
    public void updateContent(String detailContent) {
        this.content= detailContent;
    }

    // 수정, 제목
    public void updateTitle(String title) {
        this.title = title;
    }

    // 리스트, 복사해서 반환, 외부 수정 금지
    public static Map<Integer, Post> getMap() {
        return new HashMap<>(map);
    }

    // key 값으로 Post 찾아주기, 외부 공유
    public static Post findPost(int key) {
        return map.get(key);
    }


    // Getter 메서드
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return title + " " + content;
    }
}
