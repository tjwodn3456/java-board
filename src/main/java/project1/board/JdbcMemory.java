package project1.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemory implements PostRepository{

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
    public List<PostListItemDto> findAllWithAuthor() {
        String sql = "SELECT p.post_id, p.title, u.nick_name , p.created_at " +
                     "FROM posts p " +
                     "JOIN users u ON p.user_id = u.id " +
                     "ORDER BY p.user_id DESC";

        List<PostListItemDto> postList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                PostListItemDto dto = new PostListItemDto();

                dto.setPostId(rs.getInt("post_id"));
                dto.setTitle(rs.getString("title"));
                dto.setNickName(rs.getString("nick_name"));
                dto.setCreatedAt(rs.getTimestamp("created_at"));

                postList.add(dto);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("게시글 목록 조회 중 예외 발생",e);
        }
        return postList;
    }
    @Override
    public List<UserPostCountDto> countUserPosts(){
        String sql = "SELECT " +
                "u.nick_name, " +
                "COUNT(p.post_id) AS post_count " +
                "FROM users u " +
                "LEFT JOIN posts p ON u.id = p.user_id " +
                "GROUP BY u.id " +
                "ORDER BY post_count DESC, u.nick_name";

        List<UserPostCountDto> userPostCounts = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery(sql)) {

            while (rs.next()) {
                UserPostCountDto dto = new UserPostCountDto();

                dto.setNickName(rs.getString("nick_name"));
                dto.setPostCount(rs.getInt("post_count"));
                userPostCounts.add(dto);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("게시글 카운트 중 오류 발생.", e);
        }
        return userPostCounts;
    }

    @Override
    public boolean existById(int postId) {
        return findPost(postId) != null;
    }
}
