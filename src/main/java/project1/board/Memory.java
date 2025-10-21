package project1.board;

import java.util.*;
import java.util.List;

public class Memory implements PostRepository {
    private Map<Integer, Post> map = new HashMap<>();
    private int key=0;

    public Post save(Post post) {
        key++;
        post.setPostId(key);
        map.put(key, post);
        return post;
    }

    // 게시글 삭제
    @Override
    public void deleteContent(int key) {
        map.remove(key);
    }

    // 수정, 제목
    @Override
    public void updateTitle(int key, String updateTitle) {
        map.get(key).updatePostTitle(updateTitle);
    }

    // 수정, 내용
    @Override
    public void updateContent(int key, String updateContent) {
        map.get(key).updatePostContent(updateContent);
    }

    // key 값으로 Post 찾아주기
    @Override
    public Post findPost(int key) {
        return map.get(key);
    }

    // map 내 저장 값 복사본으로 반환
    @Override
    public List<Post> findAll() {
        List list = new ArrayList<>(map.values());
        Comparator<Post> comparator = new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o1.getPostId() - o2.getPostId();
            }
        };
        Collections.sort(list, comparator);
        return list;
    }

    @Override
    public List<PostListItemDto> findAllWithAuthor() {
        return List.of();
    }

    // 존재 여부 확인
    @Override
    public boolean existById(int id) {
        return map.containsKey(id);
    }

    // key 값 반환
    public int getKey() {
        return key;
    }

    @Override
    public List<UserPostCountDto> countUserPosts() {
        return List.of();
    }
}
