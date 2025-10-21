package project1.board;


import java.sql.Timestamp;

public class Post {
    private int postId;
    private String title;
    private String content;
    private int userId;
    private Timestamp createAt;


    public Post(String title, String content, int userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Post(int id, String title, String content) {
        this.postId = id;
        this.title = title;
        this.content = content;
    }

    public Post() {
    }


    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    //수정 메서드
    public void updatePostTitle(String title) {
        this.title = title;
    }

    public void updatePostContent(String content) {
        this.content = content;
    }

    // Getter 메서드
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    @Override
    public String toString() {
        return title + " " + content;
    }
}
