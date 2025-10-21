package project1.board;

import java.sql.Timestamp;

public class PostListItemDto {
    private int postId;
    private String title;
    private String nickName;
    private Timestamp createdAt;

    public PostListItemDto() {}

    public PostListItemDto(int postId, String title, String nickName, Timestamp createdAt) {
        this.postId = postId;
        this.title = title;
        this.nickName = nickName;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PostListItemDto{" +
                "id=" + postId +
                ", title='" + title + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public int getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getNickName() {
        return nickName;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
