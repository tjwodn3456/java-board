package project1.board;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.out.println("죄송합니다, database.properties 를 찾을 수 없습니다.");
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  String getUrl(){
        return properties.getProperty("db.url");
    }
    public static  String getUserName(){
        return properties.getProperty("db.username");
    }
    public static  String getPassword(){
        return properties.getProperty("db.password");
    }
}
