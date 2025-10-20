package project1.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemory implements BoardRepository{

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
    public Post save(Post post) {
        String sql = "INSERT INTO posts (title, content, user_id) VALUES (?,?,?)";

        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setInt(3, post.getUserId());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()){
                if (rs.next()) {
                    int newId = rs.getInt(1);
                    post.setPostId(newId);
                    return post;
                } else {
                    throw new SQLException("ID 조회 실패");
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteContent(int postId) {
        String sql = "DELETE FROM posts WHERE post_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, postId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows != 1) {
                System.out.println("ID: " + postId + "에 해당하는 데이터가 없거나 삭제에 실패했습니다.");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void updateTitle(int postId, String updateTitle) {
        String sql = "UPDATE posts SET title= ? WHERE post_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, updateTitle);
            pstmt.setInt(2, postId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows != 1) {
                System.out.println("ID: " + postId + "에 해당하는 데이터가 없거나 제목 수정에 실패했습니다.");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public void updateContent(int postId, String updateContent) {
        String sql = "UPDATE posts SET content= ? WHERE post_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, updateContent);
            pstmt.setInt(2, postId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows != 1) {
                System.out.println("ID: " + postId + "에 해당하는 데이터가 없거나 내용 수정에 실패했습니다.");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }


    @Override
    public Post findPost(int postId) {
        String sql = "SELECT * FROM posts WHERE post_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, postId);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    Post post = new Post();
                    post.setPostId(rs.getInt("post_id"));
                    post.setTitle(rs.getString("title"));
                    post.setContent(rs.getString("content"));
                    post.setUserId(rs.getInt("user_id"));
                    post.setCreateAt(rs.getTimestamp("created_at"));
                    return post;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Post> findAll() {
        String sql = "SELECT * FROM posts";
        List<Post> posts = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("post_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setUserId(rs.getInt("user_id"));
                post.setCreateAt(rs.getTimestamp("created_at"));

                posts.add(post);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return posts;
    }

    @Override
    public boolean existById(int postId) {
        return findPost(postId) != null;
    }
}
