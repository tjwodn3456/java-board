package project1.board;

import java.util.List;

public interface BoardRepository {
    
    // 저장
    Post save(Post post);
    
    // 삭제
    public void deleteContent(int id);

    // 수정, 내용
    void updateContent(int id, String updateContent);

    // 수정, 제목
    void updateTitle(int id, String updateTitle);

    // id 값으로 Post 찾아주기
    Post findPost(int id);

    // id 값으로 Post 존재 여부 확인
    boolean existById(int id);

    public List<PostListItemDto> findAllWithAuthor();

    // map 내 저장 값 복사본으로 반환
    public List<Post> findAll();
}

