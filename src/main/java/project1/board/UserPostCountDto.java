package project1.board;

public class UserPostCountDto {
    private String nickName;
    private int postCount;

    public UserPostCountDto() {
    }

    public UserPostCountDto(String nickName, int postCount) {
        this.nickName = nickName;
        this.postCount = postCount;
    }

    public String getNickName() {
        return nickName;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }
}
