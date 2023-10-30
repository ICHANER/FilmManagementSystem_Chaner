package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieController {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Aa123456";

    public void updateMovie(String title, String director, String cast, String plot, String duration) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // 建立数据库连接
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // 构造更新语句
            String sql = "UPDATE movie SET director = ?, cast = ?, plot = ?, duration = ? WHERE title = ?";

            // 创建预处理语句对象
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, director);
            stmt.setString(2, cast);
            stmt.setString(3, plot);
            stmt.setString(4, duration);
            stmt.setString(5, title);

            // 执行更新语句
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("影片信息已成功更新到数据库中。");
            } else {
                System.out.println("未找到要更新的影片。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接和语句对象
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertMovie(String title, String director, String cast, String plot, String duration) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // 建立数据库连接
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // 构造插入语句
            String sql = "INSERT INTO movie (title, director, cast, plot, duration) VALUES (?, ?, ?, ?, ?)";

            // 创建预处理语句对象
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, director);
            stmt.setString(3, cast);
            stmt.setString(4, plot);
            stmt.setString(5, duration);

            // 执行插入语句
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("影片信息已成功插入到数据库中。");
            } else {
                System.out.println("无法插入影片信息。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接和语句对象
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteMovie(String title) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // 建立数据库连接
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // 构造删除语句
            String sql = "DELETE FROM movie WHERE title = ?";

            // 创建预处理语句对象
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);

            // 执行删除语句
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("影片信息已成功从数据库中删除。");
            } else {
                System.out.println("未找到要删除的影片。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接和语句对象
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}