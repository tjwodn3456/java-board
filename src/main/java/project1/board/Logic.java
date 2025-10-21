package project1.board;

import java.util.List;

public class Logic {
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public Logic(PostRepository boardRepository, UserRepository userRepository) {
        this.postRepository = boardRepository;
        this.userRepository = userRepository;
    }

    // 회원 가입, 닉네임 입력
    public User newUser(String loginId, String password, String nickName){
        User user = new User(loginId, password, nickName);
        return userRepository.save(user);
    }
    // 회원 가입, 닉네임 미 입력
    public User newUser(String loginId, String password){
        User user = new User(loginId, password);
        return userRepository.save(user);
    }

    // LoginID로 회원 찾기
    public User findUserByLoginId (String loginId) {
        return userRepository.findByLoginId(loginId);
    }

    // LoginId 로 비밀번호 찾기
    public String findPasswordByLoginID (String loginId) {
        return findUserByLoginId(loginId).getPassword();
    }

    // 비밀번호 일치 여부
    public boolean isCorrectPassword(String userPassword, String inputPassword) {
        return inputPassword.equals(userPassword);
    }

    // 게시글 추가
    public void addNewPost(String title, String content, int userId){
        Post post = new Post(title, content, userId);
        postRepository.save(post);
    }

    // 디테일 리스트 생성
    public List<Post> detailMakeList(){
        return postRepository.findAll();
    }
    // 작성자 리스트 생성
    public List<PostListItemDto> authorMakeList(){
        return postRepository.findAllWithAuthor();
    }

    // 작성자별 게시글 작성 수 리스트 생성
    public List<UserPostCountDto> countPostByUsers(){
        return postRepository.countUserPosts();
    }

    // 게시글 수정
    public void updatePost(int id, String title, String content) {
        postRepository.updateTitle(id, title);
        postRepository.updateContent(id, content);
    }

    // 게시글 찾기
    public Post findPost (int id){
        return postRepository.findPost(id);
    }

    // 게시글 삭제
    public void deletePost (int id) {
        postRepository.deleteContent(id);
    }

    // 게시글이 존재하는가? or 게시글 번호가 일치하는가?
    public boolean isExitContent(int id){
        return postRepository.existById(id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
