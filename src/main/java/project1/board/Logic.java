package project1.board;

import java.util.List;

public class Logic {
    private final BoardRepository reposit;


    public Logic(BoardRepository boardRepository) {
        this.reposit = boardRepository;
    }

    // 게시글 추가
    public void addNewPost(String title, String content){
        reposit.save(title, content);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // 리스트 생성
    public List<Post> makeList(){
        return reposit.findAll();
    }

    // 게시글 수정
    public void updatePost(int id, String title, String content) {
        reposit.updateTitle(id, title);
        reposit.updateContent(id, content);
    }

    // 게시글 찾기
    public Post findPost (int id){
        return reposit.findPost(id);
    }

    // 게시글 삭제
    public void deletePost (int id) {
        reposit.deleteContent(id);
    }

    // 게시글이 존재하는가? or 게시글 번호가 일치하는가?
    public boolean isExitContent(int id){
        return reposit.existById(id);
    }
}
