package project1.board;

public interface UserRepository {

    User save(User user);

    User findByLoginId(String loginId);
}
