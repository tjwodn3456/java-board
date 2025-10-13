package project1.board;


public class Logic {

    // 게시글 추가
    public void addNewPost(String title, String content){
        Post post = new Post(title, content);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // 리스트 생성
    public void makeList(){
        Post.getMap().entrySet();
    }

    // 게시글 수정
    public void updatePost(Post post, String title, String content) {
        post.updateTitle(title);
        post.updateContent(content);
    }

    // 게시글 찾기
    public Post findPost (int key){
        return Post.findPost(key);
    }

    // 게시글 삭제
    public void deletePost (int key) {
        findPost(key).deleteContent(key);
    }

    // 게시글이 존재하는가? or 게시글 번호가 일치하는가?
    public boolean isExitContent(int key){
        return Post.getMap().containsKey(key);
    }


}
