package Controller;

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;

public class ChangePasswordController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Aa123456";

    public void changePassword(int id, String userInput) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 使用 PreparedStatement 执行 SQL 更新操作
            String updateSql = "UPDATE users SET password = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(updateSql);
            statement.setString(1, userInput);
            statement.setInt(2, id);

            // 执行更新操作
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("密码已成功更新。");
            } else {
                System.out.println("未找到匹配的用户记录。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}