package project1.board;

import java.sql.*;

public class JdbcUserRepository implements UserRepository {

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    DatabaseConfig.getUrl(),
                    DatabaseConfig.getUserName(),
                    DatabaseConfig.getPassword()
            );
        } catch (SQLException e) {
            throw new IllegalStateException("DB 연결에 실패했습니다.", e);
        }
    }


    @Override
    public User save(User user) {
        String sql = "INSERT INTO users (login_id, password, nick_name) VALUES (?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, user.getLoginId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getNickName());
            pstmt.executeUpdate();

            try(ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setUserId(rs.getInt(1));
                    return user;
                } else {
                    throw new SQLException("사용자 ID 조회 실패");
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public User findByLoginId(String loginId) {
        String sql = "SELECT * FROM users WHERE login_id = ?";

        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, loginId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setUserId(rs.getInt("id"));
                    user.setLoginId(rs.getString("login_id"));
                    user.setPassword(rs.getString("password"));
                    user.setNickName(rs.getString("nick_name"));
                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}

