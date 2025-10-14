package project1.board;

import java.util.*;
import java.util.List;

public class Memory implements BoardRepository {
    private static Map<Integer, Post> map = new HashMap<>();
    private static int key=0;

    public Post save(String title, String content) {
        key++;
        int newId = key;
        Post post = new Post(newId, title, content);
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
    public java.util.List<Post> findAll() {
        List list = new ArrayList<>(map.values());
        Comparator<Post> comparator = new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o1.getId() - o2.getId();
            }
        };
        Collections.sort(list, comparator);
        return list;
    }

    // 존재 여부 확인
    @Override
    public boolean existById(int id) {
        return map.containsKey(id);
    }

    // key 값 반환
    public static int getKey() {
        return key;
    }
}
