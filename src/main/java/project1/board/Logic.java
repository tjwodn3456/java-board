package project1.board;

import java.util.List;

public class Logic {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;


    public Logic(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
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

    // Login 하기
    //public



    // 게시글 추가
    public void addNewPost(String title, String content, int userId){
        Post post = new Post(title, content, userId);
        boardRepository.save(post);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // 디테일 리스트 생성
    public List<Post> detailMakeList(){
        return boardRepository.findAll();
    }
    // 디테일 리스트 생성
    public List<PostListItemDto> authorMakeList(){
        return boardRepository.findAllWithAuthor();
    }


    // 게시글 수정
    public void updatePost(int id, String title, String content) {
        boardRepository.updateTitle(id, title);
        boardRepository.updateContent(id, content);
    }

    // 게시글 찾기
    public Post findPost (int id){
        return boardRepository.findPost(id);
    }

    // 게시글 삭제
    public void deletePost (int id) {
        boardRepository.deleteContent(id);
    }

    // 게시글이 존재하는가? or 게시글 번호가 일치하는가?
    public boolean isExitContent(int id){
        return boardRepository.existById(id);
    }
}
